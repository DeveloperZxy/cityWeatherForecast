package com.zxy.practiceproject.model.crm.user.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.crm.user.pojo.dto.PageUserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.QueryUserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.dto.UserCategoryDTO;
import com.zxy.practiceproject.model.crm.user.pojo.entity.UserCategoryEntity;
import com.zxy.practiceproject.model.crm.user.service.UserCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/crm/userCategory")
@Slf4j
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserCategoryDTO userCategoryDTO) {
        userCategoryService.add(userCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        userCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param userCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody UserCategoryDTO userCategoryDTO) {
        userCategoryService.edit(userCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<UserCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        UserCategoryDTO userCategoryDTO  = userCategoryService.show(idDTO.getId());
        return Result.success(userCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserCategoryEntity>> listQuery(@RequestBody QueryUserCategoryDTO queryDemoDTO) {
        List<UserCategoryEntity> result = userCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageUserCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryUserCategoryDTO> dto) {
        PageResult<PageUserCategoryDTO> result = userCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryUserCategoryDTO> dto) {
        List<Tree<String>> result = userCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
