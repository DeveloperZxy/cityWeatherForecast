package com.zxy.practiceproject.model.system.config.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.system.config.pojo.dto.ConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.PageConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.dto.QueryConfigCategoryDTO;
import com.zxy.practiceproject.model.system.config.pojo.entity.ConfigCategoryEntity;
import com.zxy.practiceproject.model.system.config.service.ConfigCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/configCategory")
@Slf4j
public class ConfigCategoryController {

    @Autowired
    private ConfigCategoryService configCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ConfigCategoryDTO configCategoryDTO) {
        configCategoryService.add(configCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        configCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param configCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ConfigCategoryDTO configCategoryDTO) {
        configCategoryService.edit(configCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<ConfigCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        ConfigCategoryDTO configCategoryDTO  = configCategoryService.show(idDTO.getId());
        return Result.success(configCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<ConfigCategoryEntity>> listQuery(@RequestBody QueryConfigCategoryDTO queryDemoDTO) {
        List<ConfigCategoryEntity> result = configCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageConfigCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryConfigCategoryDTO> dto) {
        PageResult<PageConfigCategoryDTO> result = configCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryConfigCategoryDTO> dto) {
        List<Tree<String>> result = configCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
