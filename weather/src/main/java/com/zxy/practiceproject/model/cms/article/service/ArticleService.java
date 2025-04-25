package com.zxy.practiceproject.model.cms.article.service;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.cms.article.pojo.dto.ArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.PageArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.QueryArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.entity.ArticleEntity;

import java.util.List;

public interface ArticleService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ArticleDTO articleDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param articleDTO
     * @return
     */
    void edit(ArticleDTO articleDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<ArticleEntity> listQuery(QueryArticleDTO queryDictDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageArticleDTO> pageQuery(PageQuery<QueryArticleDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ArticleDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);
}
