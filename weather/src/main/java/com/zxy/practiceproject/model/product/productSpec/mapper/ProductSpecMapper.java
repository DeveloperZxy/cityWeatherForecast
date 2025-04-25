package com.zxy.practiceproject.model.product.productSpec.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.PageProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.QueryProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.entity.ProductSpecEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductSpecMapper extends BaseMapper<ProductSpecEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductSpecDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductSpecDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<ProductSpecEntity> listQuery(QueryProductSpecDTO queryConfigDTO);
}
