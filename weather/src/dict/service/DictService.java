package com.zxy.dict.service;

import com.zxy.common.pojo.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.dict.pojo.dto.DictDTO;
import com.zxy.dict.pojo.dto.PageDictDTO;
import com.zxy.dict.pojo.dto.QueryDictDTO;
import com.zxy.dict.pojo.entity.DictEntity;

import java.util.List;

public interface DictService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(DictDTO dictDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param dictDTO
     * @return
     */
    void edit(DictDTO dictDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<DictEntity> listQuery(QueryDictDTO queryDictDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageDictDTO> pageQuery(PageQuery<QueryDictDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    DictDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);
}
