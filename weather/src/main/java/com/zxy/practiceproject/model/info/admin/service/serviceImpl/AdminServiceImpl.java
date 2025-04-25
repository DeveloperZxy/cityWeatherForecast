package com.zxy.practiceproject.model.info.admin.service.serviceImpl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.common.constant.MessageConstant;
import com.zxy.common.exception.PasswordErrorException;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.info.admin.mapper.AdminCategoryMapper;
import com.zxy.practiceproject.model.info.admin.mapper.AdminMapper;
import com.zxy.practiceproject.model.info.admin.pojo.dto.AdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PasswordDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminEntity;
import com.zxy.practiceproject.model.info.admin.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminEntity> implements AdminService {
    @Autowired
    private AdminMapper configMapper;

    @Autowired
    private AdminCategoryMapper configCategoryMapper;

    /**
     * 新增
     *
     * @param
     * @return
     */
    @Override
    public void add(AdminDTO configDTO) {
        //设置一些基本属性
        configDTO.setStatus(0);
        //密码加密
        configDTO.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        //保存
        this.save(configDTO);
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
     * @param configDTO
     * @return
     */
    @Override
    public void edit(AdminDTO configDTO) {
        AdminEntity config = new AdminEntity();
        //对象属性拷贝
        BeanUtils.copyProperties(configDTO, config);
        //设置更新时间
        config.setUpdateTime(new Date());
        //更新数据库
        this.updateById(config);
    }


    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    @Override
    public List<AdminEntity> listQuery(QueryAdminDTO queryConfigDTO) {
        //创建查询条件
        LambdaQueryWrapper<AdminEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件并查询
        List<AdminEntity> list = configMapper.selectList(queryWrapper);
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
    public PageResult<PageAdminDTO> pageQuery(PageQuery<QueryAdminDTO> dto) {

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
            List<String> categoryIds = configCategoryMapper.listChildrenIdsAndSelf(categoryId);
            //将这些id 存在拦截器条件里
            dto.getFilters().setCategoryIds(categoryIds);
        }

        //查询分页数据
        IPage<PageAdminDTO> page = configMapper.pageQuery(dto.getPageable(), dto.getFilters());
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
    public AdminDTO show(String id) {
        AdminDTO configDTO = new AdminDTO();
        //创建查询条件
        LambdaQueryWrapper<AdminEntity> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件
        queryWrapper.eq(AdminEntity::getId, id);
        //查询
        AdminEntity configEntity = this.getOne(queryWrapper);
        //对象属性拷贝
        BeanUtils.copyProperties(configEntity, configDTO);
        return configDTO;
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
        LambdaUpdateWrapper<AdminEntity> updateWrapper = new LambdaUpdateWrapper<>();
        //设置更新条件
        updateWrapper.eq(AdminEntity::getId, id);
        updateWrapper.set(AdminEntity::getStatus, status);
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
    public void resetPassword(PasswordDTO dto) {
        //不能为空
        if (StrUtil.isBlank(dto.getOldPassword())|| StrUtil.isBlank(dto.getNewPasswordOne())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERR);
        }
        //查询要修改密码用户数据库中的信息
        AdminEntity one = this.getById(dto.getId());
        //旧密码不一致
        if (!DigestUtils.md5DigestAsHex(dto.getOldPassword().getBytes()).equals(one.getPassword())) {
            throw new PasswordErrorException(MessageConstant.OLD_PASSWORD_ERROR);
        }
        //新密码不一致
        if (!dto.getNewPasswordOne().equals(dto.getNewPasswordTwo())) {
            throw new PasswordErrorException(MessageConstant.NEW_PASSWORD_NOT_SAME);
        }
        //设置新密码
        one.setPassword(DigestUtils.md5DigestAsHex(dto.getNewPasswordOne().getBytes()));
        //更新新密码
        this.updateById(one);
    }
}
