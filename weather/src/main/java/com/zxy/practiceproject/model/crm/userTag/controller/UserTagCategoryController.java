package com.zxy.practiceproject.model.crm.userTag.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.UserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.PageUserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.dto.QueryUserTagCategoryDTO;
import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagCategoryEntity;
import com.zxy.practiceproject.model.crm.userTag.service.UserTagCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/crm/userTagCategory")
@Slf4j
public class UserTagCategoryController {

    @Autowired
    private UserTagCategoryService userTagCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserTagCategoryDTO userTagCategoryDTO) {
        userTagCategoryService.add(userTagCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        userTagCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param userTagCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody UserTagCategoryDTO userTagCategoryDTO) {
        userTagCategoryService.edit(userTagCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<UserTagCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        UserTagCategoryDTO userTagCategoryDTO  = userTagCategoryService.show(idDTO.getId());
        return Result.success(userTagCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserTagCategoryEntity>> listQuery(@RequestBody QueryUserTagCategoryDTO queryDemoDTO) {
        List<UserTagCategoryEntity> result = userTagCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageUserTagCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryUserTagCategoryDTO> dto) {
        PageResult<PageUserTagCategoryDTO> result = userTagCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryUserTagCategoryDTO> dto) {
        List<Tree<String>> result = userTagCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
