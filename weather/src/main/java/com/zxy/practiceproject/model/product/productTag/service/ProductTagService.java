package com.zxy.practiceproject.model.product.productTag.service;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.ProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.PageProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.QueryProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagEntity;

import java.util.List;

public interface ProductTagService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ProductTagDTO productTagDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param productTagDTO
     * @return
     */
    void edit(ProductTagDTO productTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<ProductTagEntity> listQuery(QueryProductTagDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageProductTagDTO> pageQuery(PageQuery<QueryProductTagDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ProductTagDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);

    /**
     * 设置移动端展示
     *
     * @param
     * @return 通用响应结果R，包含操作结果和消息
     */
    void setMobileShow(String id, String mobileShow);
}
