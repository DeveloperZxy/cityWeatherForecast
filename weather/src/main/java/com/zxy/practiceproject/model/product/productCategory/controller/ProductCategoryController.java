package com.zxy.practiceproject.model.product.productCategory.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.PageProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.ProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.dto.QueryProductCategoryDTO;
import com.zxy.practiceproject.model.product.productCategory.pojo.entity.ProductCategoryEntity;
import com.zxy.practiceproject.model.product.productCategory.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/productCategory")
@Slf4j
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductCategoryDTO productCategoryDTO) {
        productCategoryService.add(productCategoryDTO);
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
        productCategoryService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param productCategoryDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ProductCategoryDTO productCategoryDTO) {
        productCategoryService.edit(productCategoryDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<ProductCategoryDTO> edit(@RequestBody IdDTO idDTO) {
        ProductCategoryDTO productCategoryDTO =  productCategoryService.show(idDTO.getId());
        return Result.success(productCategoryDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<ProductCategoryEntity>> listQuery(@RequestBody QueryProductCategoryDTO queryDemoDTO) {
        List<ProductCategoryEntity> result = productCategoryService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageProductCategoryDTO>> pageQuery(@RequestBody PageQuery<QueryProductCategoryDTO> dto) {
        PageResult<PageProductCategoryDTO> result = productCategoryService.pageQuery(dto);
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
        productCategoryService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryProductCategoryDTO> dto) {
        List<Tree<String>> result = productCategoryService.treeQuery(dto);
        return Result.success(result);
    }

}
