package com.zxy.practiceproject.model.cms.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.cms.article.pojo.dto.PageArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.QueryArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.entity.ArticleCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleCategoryMapper extends BaseMapper<ArticleCategoryEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageArticleCategoryDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryArticleCategoryDTO filters );

    /**
     * 树状查询 前的  条件筛选有效列表
     * @param filters
     * @return
     */
    List<ArticleCategoryEntity> listQuery(@Param("filters") QueryArticleCategoryDTO filters);



    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    List<String> listChildrenIdsAndSelf( @Param("id") String id );

}
