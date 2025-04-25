package com.zxy.practiceproject.model.product.productTag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.PageProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.QueryProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductTagCategoryMapper extends BaseMapper<ProductTagCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductTagCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductTagCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<ProductTagCategoryEntity> listQuery(@Param("filters") QueryProductTagCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
