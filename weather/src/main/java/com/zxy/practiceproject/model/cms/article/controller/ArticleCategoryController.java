package com.zxy.practiceproject.model.cms.article.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.cms.article.pojo.dto.ArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.PageArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.QueryArticleCategoryDTO;
import com.zxy.practiceproject.model.cms.article.pojo.entity.ArticleCategoryEntity;
import com.zxy.practiceproject.model.cms.article.service.ArticleCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/cms/articleCategory")
@Slf4j
public class ArticleCategoryController {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ArticleCategoryDTO articleCategoryDTO) {
        articleCategoryService.add(articleCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        articleCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param articleCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ArticleCategoryDTO articleCategoryDTO) {
        articleCategoryService.edit(articleCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<ArticleCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        ArticleCategoryDTO articleCategoryDTO  = articleCategoryService.show(idDTO.getId());
        return Result.success(articleCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<ArticleCategoryEntity>> listQuery(@RequestBody QueryArticleCategoryDTO queryDemoDTO) {
        List<ArticleCategoryEntity> result = articleCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageArticleCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryArticleCategoryDTO> dto) {
        PageResult<PageArticleCategoryDTO> result = articleCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryArticleCategoryDTO> dto) {
        List<Tree<String>> result = articleCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
