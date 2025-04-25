package com.zxy.practiceproject.model.crm.user.service;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.crm.user.pojo.dto.ChangePasswordDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.PageUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.QueryUserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.UserDTO;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(UserDTO userDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param userDTO
     * @return
     */
    void edit(UserDTO userDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<UserEntity> listQuery(QueryUserDTO queryDictDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageUserDTO> pageQuery(PageQuery<QueryUserDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    UserDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);
    /**
     * 设置密码
     *
     * @param dto 包含ID和状态信息的DTO对象
     * @return 通用响应结果R，包含操作结果和消息
     */
    void changePassword(ChangePasswordDTO dto);
}
