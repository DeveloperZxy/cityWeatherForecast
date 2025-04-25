package com.zxy.practiceproject.model.cms.article.controller;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.cms.article.pojo.dto.ArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.PageArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.dto.QueryArticleDTO;
import com.zxy.practiceproject.model.cms.article.pojo.entity.ArticleEntity;
import com.zxy.practiceproject.model.cms.article.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/cms/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService configService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ArticleDTO configDTO) {
        configService.add(configDTO);
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
        configService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param configDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ArticleDTO configDTO) {
        configService.edit(configDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<ArticleDTO> edit(@RequestBody IdDTO idDTO) {
        ArticleDTO configDTO =  configService.show(idDTO.getId());
        return Result.success(configDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<ArticleEntity>> listQuery(@RequestBody QueryArticleDTO queryDemoDTO) {
        List<ArticleEntity> result = configService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageArticleDTO>> pageQuery(@RequestBody PageQuery<QueryArticleDTO> dto) {
        PageResult<PageArticleDTO> result = configService.pageQuery(dto);
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
        configService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }
}
