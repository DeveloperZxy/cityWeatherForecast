package com.zxy.practiceproject.model.cms.articleTag.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.ArticleTagCategoryDTO;
import com.zxy.practiceproject.model.cms.articleTag.service.ArticleTagCategoryService;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.PageArticleTagCategoryDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.QueryArticleTagCategoryDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.entity.ArticleTagCategoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/cms/articleTagCategory")
@Slf4j
public class ArticleTagCategoryController {

    @Autowired
    private ArticleTagCategoryService articleTagCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ArticleTagCategoryDTO articleTagCategoryDTO) {
        articleTagCategoryService.add(articleTagCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        articleTagCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param articleTagCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ArticleTagCategoryDTO articleTagCategoryDTO) {
        articleTagCategoryService.edit(articleTagCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<ArticleTagCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        ArticleTagCategoryDTO articleTagCategoryDTO  = articleTagCategoryService.show(idDTO.getId());
        return Result.success(articleTagCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<ArticleTagCategoryEntity>> listQuery(@RequestBody QueryArticleTagCategoryDTO queryDemoDTO) {
        List<ArticleTagCategoryEntity> result = articleTagCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageArticleTagCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryArticleTagCategoryDTO> dto) {
        PageResult<PageArticleTagCategoryDTO> result = articleTagCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryArticleTagCategoryDTO> dto) {
        List<Tree<String>> result = articleTagCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
