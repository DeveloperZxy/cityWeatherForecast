package com.zxy.practiceproject.model.product.productBrand.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.product.productBrand.pojo.dto.PageProductBrandDTO;
import com.zxy.practiceproject.model.product.productBrand.pojo.dto.QueryProductBrandDTO;
import com.zxy.practiceproject.model.product.productBrand.pojo.entity.ProductBrandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductBrandMapper extends BaseMapper<ProductBrandEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductBrandDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductBrandDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<ProductBrandEntity> listQuery(QueryProductBrandDTO queryConfigDTO);
}
