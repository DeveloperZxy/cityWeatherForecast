package com.zxy.practiceproject.model.cms.articleTag.controller;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.PageArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.QueryArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.dto.ArticleTagDTO;
import com.zxy.practiceproject.model.cms.articleTag.pojo.entity.ArticleTagEntity;
import com.zxy.practiceproject.model.cms.articleTag.service.ArticleTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/cms/articleTag")
@Slf4j
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ArticleTagDTO articleTagDTO) {
        articleTagService.add(articleTagDTO);
        return Result.success();
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        articleTagService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param articleTagDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ArticleTagDTO articleTagDTO) {
        articleTagService.edit(articleTagDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<ArticleTagDTO> edit(@RequestBody IdDTO idDTO) {
        ArticleTagDTO articleTagDTO =  articleTagService.show(idDTO.getId());
        return Result.success(articleTagDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<ArticleTagEntity>> listQuery(@RequestBody QueryArticleTagDTO queryDemoDTO) {
        List<ArticleTagEntity> result = articleTagService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageArticleTagDTO>> pageQuery(@RequestBody PageQuery<QueryArticleTagDTO> dto) {
        PageResult<PageArticleTagDTO> result = articleTagService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 设置状态
     *
     * @param dto 包含ID和状态信息的DTO对象
     * @return 通用响应结果R，包含操作结果和消息
     */
    @PostMapping(value = {"/status"})
    public Result setStatus(@RequestBody IdStatusDTO dto) {
        articleTagService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }
}
