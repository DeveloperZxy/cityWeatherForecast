package com.zxy.practiceproject.model.user.shop.productInfo.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.PageProductRecordDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.ProductRecordDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.QueryProductRecordDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductRecordEntity;

import java.util.List;

public interface ProductRecordService extends IService<ProductRecordEntity> {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ProductRecordDTO productTagDTO);

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
    void edit(ProductRecordDTO productTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<ProductRecordEntity> listQuery(QueryProductRecordDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageProductRecordDTO> pageQuery(PageQuery<QueryProductRecordDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ProductRecordDTO show(String id);

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
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryProductRecordDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);
}
