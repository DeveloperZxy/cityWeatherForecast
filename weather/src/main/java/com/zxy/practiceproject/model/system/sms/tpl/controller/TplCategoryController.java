package com.zxy.practiceproject.model.system.sms.tpl.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.TplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.PageTplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.dto.QueryTplCategoryDTO;
import com.zxy.practiceproject.model.system.sms.tpl.pojo.entity.TplCategoryEntity;
import com.zxy.practiceproject.model.system.sms.tpl.service.TplCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/sms/tplCategory")
@Slf4j
public class TplCategoryController {

    @Autowired
    private TplCategoryService tplCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody TplCategoryDTO tplCategoryDTO) {
        tplCategoryService.add(tplCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        tplCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param tplCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody TplCategoryDTO tplCategoryDTO) {
        tplCategoryService.edit(tplCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<TplCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        TplCategoryDTO tplCategoryDTO  = tplCategoryService.show(idDTO.getId());
        return Result.success(tplCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<TplCategoryEntity>> listQuery(@RequestBody QueryTplCategoryDTO queryDemoDTO) {
        List<TplCategoryEntity> result = tplCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageTplCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryTplCategoryDTO> dto) {
        PageResult<PageTplCategoryDTO> result = tplCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryTplCategoryDTO> dto) {
        List<Tree<String>> result = tplCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
