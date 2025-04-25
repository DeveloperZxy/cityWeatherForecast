package com.zxy.practiceproject.model.crm.user.service.serviceImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.crm.user.mapper.UserCategoryMapper;
import com.zxy.practiceproject.model.crm.user.mapper.UserMapper;
import com.zxy.practiceproject.model.crm.user.pojo.dto.ChangePasswordDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.PageUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.QueryUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.UserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;
import com.zxy.practiceproject.model.crm.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserCategoryMapper userCategoryMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(UserDTO userDTO) {
        //设置一些基本属性

        //保存
        this.save(userDTO);
    }


    /**
     * 删除
     *
     * @param
     * @return
     */
    @Override
    public void del(IdDTO idDTO) {
        this.removeById(idDTO.getId());
    }


    /**
     * 编辑
     *
     * @param userDTO
     * @return
     */
    @Override
    public void edit(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(userDTO, user);
        //设置更新时间
        user.setUpdateTime(new Date());
        //更新数据库
        this.updateById(user);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    @Override
    public List<UserEntity> listQuery(QueryUserDTO queryConfigDTO) {
        //创建查询条件
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件并查询
        List<UserEntity> list = userMapper.selectList(queryWrapper);
        //返回查询结果
        return list;
    }

    /**
     * 分页查询
     *
     * @param dto
     * @return
     */

    @Override
    public PageResult<PageUserDTO> pageQuery(PageQuery<QueryUserDTO> dto) {

        /**
         * 如果分类是 '0' 全部，则去掉分类查询条件
         */
        if (ObjectUtil.equal(dto.getFilters().getCategoryId(), "0")) {
            dto.getFilters().setCategoryId(null);
        }

        //接收前端发送的时间段 数组，拆开并塞值     设置时间范围
        //这是Java层面处理时间
//        if(ArrayUtil.isNotEmpty(dto.getFilters().getCreatedTime())){
//            dto.getFilters().setCreationTimeStart(DateUtil.beginOfDay(dto.getFilters().getCreatedTime()[0]));
//            dto.getFilters().setCreationTimeEnd(DateUtil.endOfDay(dto.getFilters().getCreatedTime()[1]));
//        }

        //查询要查询的   分类id 及其 子分类id    将这些id存起来
        String categoryId = dto.getFilters().getCategoryId();
        if (StrUtil.isNotBlank(categoryId)) {
            List<String> categoryIds = userCategoryMapper.listChildrenIdsAndSelf(categoryId);
            //将这些id 存在拦截器条件里
            dto.getFilters().setCategoryIds(categoryIds);
        }

        //查询分页数据
        IPage<PageUserDTO> page = userMapper.pageQuery(dto.getPageable(), dto.getFilters());
        //返回分页数据
        return new PageResult<>(page);

    }

    /**
     * 根据id获取详情
     *
     * @param id
     * @return
     */
    @Override
    public UserDTO show(String id) {
        UserDTO userDTO = new UserDTO();
        //创建查询条件
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(UserEntity::getId, id);
        //查询
        UserEntity userEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(userEntity, userDTO);
        return userDTO;
    }

    /**
     * 设置状态
     *
     * @param id
     * @param status
     */
    @Override
    public void setStatus(String id, Integer status) {
        //创建更新条件
        LambdaUpdateWrapper<UserEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(UserEntity::getId, id);
        updateWrapper.set(UserEntity::getStatus, status);
        //更新状态
        this.update(updateWrapper);
    }

    /**
     * 设置密码
     *
     * @param
     * @return 通用响应结果R，包含操作结果和消息
     */
    @Override
    public void changePassword(ChangePasswordDTO dto) {
        //密码加密
        dto.setOldPassword(DigestUtils.md5DigestAsHex(dto.getOldPassword().getBytes()));
        //校验旧密码是否正确
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserEntity::getId, dto.getId());
        queryWrapper.eq(UserEntity::getPassword, dto.getOldPassword());
        //查询旧密码是否正确
        if (this.count(queryWrapper) == 0) {
            throw new RuntimeException("旧密码不正确");
        }
        dto.setNewPassword(DigestUtils.md5DigestAsHex(dto.getNewPassword().getBytes()));
        //创建更新条件
        LambdaUpdateWrapper<UserEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(UserEntity::getId, dto.getId());
        updateWrapper.set(UserEntity::getPassword, dto.getNewPassword());
        //更新状态
        this.update(updateWrapper);
    }
}
