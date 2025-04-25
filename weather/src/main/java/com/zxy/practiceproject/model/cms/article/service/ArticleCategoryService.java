package com.zxy.practiceproject.model.cms.article.service;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.cms.article.pojo.dto.ArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.PageArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.QueryArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.entity.ArticleCategoryEntity;

import java.util.List;

public interface ArticleCategoryService {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void add(ArticleCategoryDTO articleDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void del(String id);


    /**
     * 编辑
     * @param articleDTO
     * @return
     */
    void edit(ArticleCategoryDTO articleDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<DictEntity>为查询结果列表
     */
    List<ArticleCategoryEntity> listQuery(QueryArticleCategoryDTO queryDictDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageArticleCategoryDTO> pageQuery(PageQuery<QueryArticleCategoryDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    ArticleCategoryDTO show(String id);

    /**
     * 获取树形结构
     * @param dto
     * @return
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryArticleCategoryDTO> dto);


    /**
     * 根据ID列表子级和自身
     * @param id
     * @return
     */
    public List<String> listChildrenIdsAndSelf(String id);
}
