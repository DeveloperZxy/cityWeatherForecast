package com.zxy.practiceproject.model.product.productTag.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.ProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.PageProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.QueryProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagCategoryEntity;

import java.util.List;

public interface ProductTagCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ProductTagCategoryDTO productTagDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(String id);


    /**
     * 编辑
     * @param productTagDTO
     * @return
     */
    void edit(ProductTagCategoryDTO productTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<ConfigEntity>为查询结果列表
     */
    List<ProductTagCategoryEntity> listQuery(QueryProductTagCategoryDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageProductTagCategoryDTO> pageQuery(PageQuery<QueryProductTagCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ProductTagCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryProductTagCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
