package com.zxy.practiceproject.login.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.constant.JwtClaimsConstant;
import com.zxy.common.constant.MessageConstant;
import com.zxy.common.constant.StatusConstant;
import com.zxy.common.exception.AccountNotFoundException;
import com.zxy.common.exception.PasswordErrorException;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.properties.JwtProperties;
import com.zxy.common.utils.JwtUtil;
import com.zxy.practiceproject.login.mapper.UsersMapper;
import com.zxy.practiceproject.login.pojo.dto.UserLoginDTO;
import com.zxy.practiceproject.login.pojo.dto.UserLoginVO;
import com.zxy.practiceproject.login.pojo.entity.User;
import com.zxy.practiceproject.login.service.UsersService;
import com.zxy.practiceproject.model.crm.user.mapper.UserMapper;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;
import com.zxy.practiceproject.model.crm.user.service.UserService;
import com.zxy.practiceproject.model.system.permission.pojo.dto.QueryPermissionInfoDTO;
import com.zxy.practiceproject.model.system.permission.pojo.entity.PermissionInfoEntity;
import com.zxy.practiceproject.model.system.permission.service.serviceImpl.PermissionInfoServiceImpl;
import com.zxy.practiceproject.model.system.role.pojo.entity.RoleInfoEntity;
import com.zxy.practiceproject.model.system.role.service.RoleInfoService;
import com.zxy.practiceproject.model.system.role.service.serviceImpl.RoleInfoServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;


@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, UserEntity> implements UsersService {
    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private RoleInfoServiceImpl roleInfoServiceImpl;

    @Autowired
    private PermissionInfoServiceImpl permissionInfoServiceImpl;



    /**
     * 登录
     *
     * @param userLoginDTO
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {

        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        UserEntity user = userMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (user == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对

        // 对前端传过来的密码进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getStatus() == StatusConstant.DISABLE) {
            //账号被锁定
            throw new  RuntimeException(MessageConstant.ACCOUNT_LOCKED);
        }


        //3.登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, user.getId());
        String token = JwtUtil.createJWT(jwtProperties.getAdminSecretKey(), jwtProperties.getAdminTtl(), claims);

        //赋值需要返回实体对象的数据
        UserLoginVO employeeLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(user, employeeLoginVO);
        employeeLoginVO.setId(user.getId());
        employeeLoginVO.setAvatar(user.getImage());
        employeeLoginVO.setUsername(user.getUsername());
        employeeLoginVO.setNickname(user.getName());
        employeeLoginVO.setRoles(CollUtil.newArrayList(user.getUsername()));
        employeeLoginVO.setPermissions(CollUtil.newArrayList("*:*:*"));
        employeeLoginVO.setAccessToken(token);
        employeeLoginVO.setRefreshToken(token);
        employeeLoginVO.setExpires(DateUtil.offsetHour(new Date(), 3));

        //返回实体对象
        return employeeLoginVO;
    }


    /**
     * 获取到Roles后，从而获取权限列表
     *
     * @param
     * @return
     */
    public List<Tree<String>> getPermissions(String id) {
        //赋予登陆者身份
        id=JwtUtil.getLoginUserId();
        //先判断是不是管理员
        if (id.equals("1")) {
            //如果是管理员，则获取到所有的权限
            List<PermissionInfoEntity> list = permissionInfoServiceImpl.list();
            //构建查询条件
            QueryPermissionInfoDTO queryPermissionInfoDTO = new QueryPermissionInfoDTO();
            queryPermissionInfoDTO.setIncludeRoot("0");
            TreeQueryDTO treeQueryDTO = new TreeQueryDTO();
            treeQueryDTO.setFilters(queryPermissionInfoDTO);
            //查询
            List<Tree<String>> trees = permissionInfoServiceImpl.treeQuery(treeQueryDTO);
            return trees;
        }

        //获取到用户角色RolesIds
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getId, id);
        UserEntity user = userMapper.selectOne(wrapper);
        List<String> userRolesIds = user.getRoles();
        //RolesIds判断是否为空

        if (ArrayUtil.isEmpty(userRolesIds)) {
            return new ArrayList<>();
        }


        List<String> permissionIds = new ArrayList<>();

        //通过rolesIds获取到permissionIds
        for (String userRoleId : userRolesIds) {
            RoleInfoEntity role = roleInfoServiceImpl.getById(userRoleId);
            role.getCategoryIds().forEach(permissionIds::add);
        }
        //permissionIds去重
        permissionIds = CollUtil.distinct(permissionIds);

        List<String> newPermissionIds = new ArrayList<>();


        List<Tree<String>> permissionTree = permissionInfoServiceImpl.getTree("0");

        if (CollUtil.isNotEmpty(permissionIds)) {
            //通过permissionIds获取到每个权限Id的父级，方便形成树
            for (String permissionId : permissionIds) {
                List<String> permissionParentIds = permissionInfoServiceImpl.listParentIdsAndSelf(permissionId,permissionTree);   // [{},{},{}]
//                permissionParentIds.forEach(newPermissionIds::add);
                newPermissionIds.addAll(permissionParentIds);

            }
        }

        newPermissionIds=CollUtil.distinct(newPermissionIds);

        //将permissionIds换为permissionEntity实体集合
        List<PermissionInfoEntity> permissions = permissionInfoServiceImpl.listByIds(newPermissionIds);
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        if (CollUtil.isNotEmpty(permissions)) {
            //将list转化成树节点列表

            for (PermissionInfoEntity item : permissions) {
                TreeNode<String> node = new TreeNode<>(item.getId(), item.getCategoryId(), item.getName(), item.getStatus());
                //设置自定义属性并塞值
                Map<String, Object> extra = new HashMap<>();
                extra.put("status", item.getStatus());
                extra.put("sort", item.getSort());
                extra.put("createTime", DateUtil.format(item.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                extra.put("updateTime", item.getUpdateTime());
                extra.put("path", item.getPath());
                extra.put("meta", item.getMeta());
                extra.put("component", item.getComponent());
                extra.put("redirect", item.getRedirect());

                node.setExtra(extra);
                nodeList.add(node);

            }
        }

        List<Tree<String>> trees = TreeUtil.build(nodeList, "0");

        return trees;
    }
}
