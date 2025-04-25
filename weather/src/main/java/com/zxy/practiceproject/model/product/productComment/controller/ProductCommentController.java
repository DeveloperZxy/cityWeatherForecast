package com.zxy.practiceproject.model.product.productComment.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.product.productComment.pojo.dto.PageProductCommentDTO;
import com.zxy.practiceproject.model.product.productComment.pojo.dto.ProductCommentDTO;
import com.zxy.practiceproject.model.product.productComment.pojo.dto.QueryProductCommentDTO;
import com.zxy.practiceproject.model.product.productComment.pojo.entity.ProductCommentEntity;
import com.zxy.practiceproject.model.product.productComment.service.ProductCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/productComment")
@Slf4j
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductCommentDTO productCommentDTO) {
        productCommentService.add(productCommentDTO);
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
        productCommentService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param productCommentDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ProductCommentDTO productCommentDTO) {
        productCommentService.edit(productCommentDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<ProductCommentDTO> edit(@RequestBody IdDTO idDTO) {
        ProductCommentDTO productCommentDTO =  productCommentService.show(idDTO.getId());
        return Result.success(productCommentDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<ProductCommentEntity>> listQuery(@RequestBody QueryProductCommentDTO queryDemoDTO) {
        List<ProductCommentEntity> result = productCommentService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageProductCommentDTO>> pageQuery(@RequestBody PageQuery<QueryProductCommentDTO> dto) {
        PageResult<PageProductCommentDTO> result = productCommentService.pageQuery(dto);
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
        productCommentService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryProductCommentDTO> dto) {
        List<Tree<String>> result = productCommentService.treeQuery(dto);
        return Result.success(result);
    }

}
