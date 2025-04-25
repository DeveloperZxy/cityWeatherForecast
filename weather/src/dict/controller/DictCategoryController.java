package com.zxy.dict.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.IdDTO;
import com.zxy.common.pojo.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.dict.pojo.dto.DictCategoryDTO;
import com.zxy.dict.pojo.dto.PageDictCategoryDTO;
import com.zxy.dict.pojo.dto.QueryDictCategoryDTO;
import com.zxy.dict.pojo.entity.DictCategoryEntity;
import com.zxy.dict.service.DictCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/dictCategory")
@Slf4j
public class DictCategoryController {

    @Autowired
    private DictCategoryService dictCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody DictCategoryDTO dictCategoryDTO) {
        dictCategoryService.add(dictCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        dictCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param dictCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody DictCategoryDTO dictCategoryDTO) {
        dictCategoryService.edit(dictCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<DictCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        DictCategoryDTO dictCategoryDTO  = dictCategoryService.show(idDTO.getId());
        return Result.success(dictCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<DictCategoryEntity>> listQuery(@RequestBody QueryDictCategoryDTO queryDemoDTO) {
        List<DictCategoryEntity> result = dictCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageDictCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryDictCategoryDTO> dto) {
        PageResult<PageDictCategoryDTO> result = dictCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryDictCategoryDTO> dto) {
        List<Tree<String>> result = dictCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
