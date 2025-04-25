package com.zxy.practiceproject.model.info.admin.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.info.admin.pojo.dto.AdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.PageAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.dto.QueryAdminCategoryDTO;
import com.zxy.practiceproject.model.info.admin.pojo.entity.AdminCategoryEntity;
import com.zxy.practiceproject.model.info.admin.service.AdminCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/org")
@Slf4j
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService configCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody AdminCategoryDTO configCategoryDTO) {
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
    public Result edit(@RequestBody AdminCategoryDTO configCategoryDTO) {
        configCategoryService.edit(configCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<AdminCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        AdminCategoryDTO configCategoryDTO  = configCategoryService.show(idDTO.getId());
        return Result.success(configCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<AdminCategoryEntity>> listQuery(@RequestBody QueryAdminCategoryDTO queryDemoDTO) {
        List<AdminCategoryEntity> result = configCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageAdminCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryAdminCategoryDTO> dto) {
        PageResult<PageAdminCategoryDTO> result = configCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryAdminCategoryDTO> dto) {
        List<Tree<String>> result = configCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
