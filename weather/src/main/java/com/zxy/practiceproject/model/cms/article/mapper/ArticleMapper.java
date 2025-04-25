package com.zxy.practiceproject.model.cms.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.cms.article.pojo.dto.PageArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.QueryArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageArticleDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryArticleDTO filters);


}
