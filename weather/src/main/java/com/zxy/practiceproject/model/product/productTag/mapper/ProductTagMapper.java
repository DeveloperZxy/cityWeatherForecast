package com.zxy.practiceproject.model.product.productTag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.PageProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.QueryProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductTagMapper extends BaseMapper<ProductTagEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductTagDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductTagDTO filters);


}
