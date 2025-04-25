package com.zxy.practiceproject.model.cms.articleTag.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.ArticleTagCategoryDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.PageArticleTagCategoryDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.QueryArticleTagCategoryDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.entity.ArticleTagCategoryEntity;

import java.util.List;

public interface ArticleTagCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ArticleTagCategoryDTO articleTagDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(String id);


    /**
     * 编辑
     * @param articleTagDTO
     * @return
     */
    void edit(ArticleTagCategoryDTO articleTagDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<UserTagEntity>为查询结果列表
     */
    List<ArticleTagCategoryEntity> listQuery(QueryArticleTagCategoryDTO queryUserTagDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageArticleTagCategoryDTO> pageQuery(PageQuery<QueryArticleTagCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ArticleTagCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryArticleTagCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
