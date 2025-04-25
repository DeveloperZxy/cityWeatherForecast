package com.zxy.practiceproject.model.user.shop.productInfo.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.PageProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.ProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.QueryProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductInfoEntity;

import java.util.List;

public interface ProductInfoService extends IService<ProductInfoEntity> {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ProductInfoDTO productTagDTO);

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
    void edit(ProductInfoDTO productTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<ProductInfoEntity> listQuery(QueryProductInfoDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageProductInfoDTO> pageQuery(PageQuery<QueryProductInfoDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ProductInfoDTO show(String id);

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
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryProductInfoDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);
}
