package com.zxy.practiceproject.model.product.productCategory.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.PageProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.ProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.QueryProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.entity.ProductCategoryEntity;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ProductCategoryDTO productTagDTO);

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
    void edit(ProductCategoryDTO productTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<ProductCategoryEntity> listQuery(QueryProductCategoryDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageProductCategoryDTO> pageQuery(PageQuery<QueryProductCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ProductCategoryDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);


    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryProductCategoryDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);
}
