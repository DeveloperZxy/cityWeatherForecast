package com.zxy.practiceproject.model.product.productCategory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.PageProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.QueryProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductCategoryDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<ProductCategoryEntity> listQuery(QueryProductCategoryDTO queryConfigDTO);
}
