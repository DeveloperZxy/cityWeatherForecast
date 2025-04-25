package com.zxy.practiceproject.model.product.productComment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.product.productComment.pojo.dto.PageProductCommentDTO;
import com.zxy.practiceproject.model.product.productComment.pojo.dto.QueryProductCommentDTO;
import com.zxy.practiceproject.model.product.productComment.pojo.entity.ProductCommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCommentMapper extends BaseMapper<ProductCommentEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageProductCommentDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryProductCommentDTO filters);


    List<String> listChildrenIdsAndSelf(@Param("id") String id);

    List<ProductCommentEntity> listQuery(QueryProductCommentDTO queryConfigDTO);
}
