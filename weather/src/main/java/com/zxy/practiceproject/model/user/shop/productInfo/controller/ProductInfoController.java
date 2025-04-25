package com.zxy.practiceproject.model.user.shop.productInfo.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.PageProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.ProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto.QueryProductInfoDTO;
import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductInfoEntity;
import com.zxy.practiceproject.model.user.shop.productInfo.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/productInfo")
@Slf4j
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductInfoDTO productInfoDTO) {
        productInfoService.add(productInfoDTO);
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
        productInfoService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param productInfoDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ProductInfoDTO productInfoDTO) {
        productInfoService.edit(productInfoDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<ProductInfoDTO> edit(@RequestBody IdDTO idDTO) {
        ProductInfoDTO productInfoDTO =  productInfoService.show(idDTO.getId());
        return Result.success(productInfoDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<ProductInfoEntity>> listQuery(@RequestBody QueryProductInfoDTO queryDemoDTO) {
        List<ProductInfoEntity> result = productInfoService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageProductInfoDTO>> pageQuery(@RequestBody PageQuery<QueryProductInfoDTO> dto) {
        PageResult<PageProductInfoDTO> result = productInfoService.pageQuery(dto);
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
        productInfoService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryProductInfoDTO> dto) {
        List<Tree<String>> result = productInfoService.treeQuery(dto);
        return Result.success(result);
    }

}
