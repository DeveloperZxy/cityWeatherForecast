package com.zxy.practiceproject.model.user.shop.productInfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.PageProductRecordDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.QueryProductRecordDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductRecordMapper extends BaseMapper<ProductRecordEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductRecordDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductRecordDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<ProductRecordEntity> listQuery(QueryProductRecordDTO queryConfigDTO);
}
