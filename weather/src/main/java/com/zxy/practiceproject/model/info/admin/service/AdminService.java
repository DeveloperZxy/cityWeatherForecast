package com.zxy.practiceproject.model.info.admin.service;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.info.admin.pojo.dto.AdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PasswordDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminEntity;

import java.util.List;

public interface AdminService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(AdminDTO configDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param configDTO
     * @return
     */
    void edit(AdminDTO configDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<AdminEntity> listQuery(QueryAdminDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageAdminDTO> pageQuery(PageQuery<QueryAdminDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    AdminDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);


    /**
     * 设置密码
     *
     * @param
     * @return 通用响应结果R，包含操作结果和消息
     */
    void resetPassword(PasswordDTO dto);
}
