package com.zxy.practiceproject.model.cms.articleTag.service;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.PageArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.QueryArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.ArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.entity.ArticleTagEntity;

import java.util.List;

public interface ArticleTagService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ArticleTagDTO articleTagDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(IdDTO idDTO);


    /**
     * 编辑
     * @param articleTagDTO
     * @return
     */
    void edit(ArticleTagDTO articleTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<ArticleTagEntity> listQuery(QueryArticleTagDTO queryUserTagDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageArticleTagDTO> pageQuery(PageQuery<QueryArticleTagDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ArticleTagDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);
}
