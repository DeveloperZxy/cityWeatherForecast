package com.zxy.practiceproject.model.user.shop.productInfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.PageProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.QueryProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfoEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductInfoDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductInfoDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<ProductInfoEntity> listQuery(QueryProductInfoDTO queryConfigDTO);
}
