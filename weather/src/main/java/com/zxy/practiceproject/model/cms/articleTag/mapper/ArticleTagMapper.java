package com.zxy.practiceproject.model.cms.articleTag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.PageArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.QueryArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.entity.ArticleTagEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTagEntity> {
    /**
     * 分页查询
     * @param page
     * @param filters
     * @return
     */
    IPage<PageArticleTagDTO> pageQuery(@Param("page") Page page, @Param("filters") QueryArticleTagDTO filters);


}
