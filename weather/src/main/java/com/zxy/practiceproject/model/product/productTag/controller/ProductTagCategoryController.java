package com.zxy.practiceproject.model.product.productTag.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.ProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.PageProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.QueryProductTagCategoryDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagCategoryEntity;
import com.zxy.practiceproject.model.product.productTag.service.ProductTagCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/productTagCategory")
@Slf4j
public class ProductTagCategoryController {

    @Autowired
    private ProductTagCategoryService productTagCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductTagCategoryDTO productTagCategoryDTO) {
        productTagCategoryService.add(productTagCategoryDTO);
        return Result.success();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteById(@RequestBody IdDTO idDTO) {
        productTagCategoryService.del(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     * @param productTagCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ProductTagCategoryDTO productTagCategoryDTO) {
        productTagCategoryService.edit(productTagCategoryDTO);
        return Result.success();
    }
    /**
     * show
     * @param
     * @return
     */
    @PostMapping("/show")
    public Result<ProductTagCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        ProductTagCategoryDTO productTagCategoryDTO  = productTagCategoryService.show(idDTO.getId());
        return Result.success(productTagCategoryDTO);
    }


    /**
     * 列表查询
     * @param
     */
    @PostMapping("/list")
    public Result<List<ProductTagCategoryEntity>> listQuery(@RequestBody QueryProductTagCategoryDTO queryDemoDTO) {
        List<ProductTagCategoryEntity> result = productTagCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询 CartoonInfo信息
     */
    @PostMapping ("/page")
    public Result<PageResult<PageProductTagCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryProductTagCategoryDTO> dto) {
        PageResult<PageProductTagCategoryDTO> result = productTagCategoryService.pageQuery(dto);
        return Result.success(result);
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryProductTagCategoryDTO> dto) {
        List<Tree<String>> result = productTagCategoryService.treeQuery(dto);
        return Result.success(result);
    }
}
