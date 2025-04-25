package com.zxy.practiceproject.model.product.productSpec.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.PageProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.ProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.dto.QueryProductSpecDTO;
import com.zxy.practiceproject.model.product.productSpec.pojo.entity.ProductSpecEntity;
import com.zxy.practiceproject.model.product.productSpec.service.ProductSpecService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/productSpec")
@Slf4j
public class ProductSpecController {

    @Autowired
    private ProductSpecService productBrandService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductSpecDTO productBrandDTO) {
        productBrandService.add(productBrandDTO);
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
        productBrandService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param productBrandDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ProductSpecDTO productBrandDTO) {
        productBrandService.edit(productBrandDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<ProductSpecDTO> edit(@RequestBody IdDTO idDTO) {
        ProductSpecDTO productBrandDTO =  productBrandService.show(idDTO.getId());
        return Result.success(productBrandDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<ProductSpecEntity>> listQuery(@RequestBody QueryProductSpecDTO queryDemoDTO) {
        List<ProductSpecEntity> result = productBrandService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageProductSpecDTO>> pageQuery(@RequestBody PageQuery<QueryProductSpecDTO> dto) {
        PageResult<PageProductSpecDTO> result = productBrandService.pageQuery(dto);
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
        productBrandService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryProductSpecDTO> dto) {
        List<Tree<String>> result = productBrandService.treeQuery(dto);
        return Result.success(result);
    }

}
