package com.zxy.practiceproject.model.system.config.service;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.system.config.pojo.dto.ConfigDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.PageConfigDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.QueryConfigDTO;
import com.zxy.practiceproject.model.system.config.pojo.entity.ConfigEntity;

import java.util.List;

public interface ConfigService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ConfigDTO configDTO);

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
    void edit(ConfigDTO configDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<ConfigEntity> listQuery(QueryConfigDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageConfigDTO> pageQuery(PageQuery<QueryConfigDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ConfigDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);

    public void setValueByCode(String code,String value);

    public String getValueByCode(String code);
}
