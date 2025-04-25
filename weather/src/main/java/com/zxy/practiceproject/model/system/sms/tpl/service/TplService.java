package com.zxy.practiceproject.model.system.sms.tpl.service;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.TplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.PageTplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.QueryTplDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.entity.TplEntity;

import java.util.List;

public interface TplService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(TplDTO tplDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param tplDTO
     * @return
     */
    void edit(TplDTO tplDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<TplEntity> listQuery(QueryTplDTO queryDictDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageTplDTO> pageQuery(PageQuery<QueryTplDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    TplDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);
}
