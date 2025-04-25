package com.zxy.practiceproject.model.product.productTag.controller;

import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.IdMobileShowDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.ProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.PageProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.dto.QueryProductTagDTO;
import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagEntity;
import com.zxy.practiceproject.model.product.productTag.service.ProductTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/product/productTag")
@Slf4j
public class ProductTagController{

    @Autowired
    private ProductTagService productTagService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody ProductTagDTO productTagDTO) {
        productTagService.add(productTagDTO);
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
        productTagService.del(idDTO);
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param productTagDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody ProductTagDTO productTagDTO) {
        productTagService.edit(productTagDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<ProductTagDTO> edit(@RequestBody IdDTO idDTO) {
        ProductTagDTO productTagDTO =  productTagService.show(idDTO.getId());
        return Result.success(productTagDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<ProductTagEntity>> listQuery(@RequestBody QueryProductTagDTO queryDemoDTO) {
        List<ProductTagEntity> result = productTagService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageProductTagDTO>> pageQuery(@RequestBody PageQuery<QueryProductTagDTO> dto) {
        PageResult<PageProductTagDTO> result = productTagService.pageQuery(dto);
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
        productTagService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }
    /**
     * 设置移动端展示
     *
     * @param dto 包含ID和状态信息的DTO对象
     * @return 通用响应结果R，包含操作结果和消息
     */
    @PostMapping(value = {"/mobileShow"})
    public Result setMobileShow(@RequestBody IdMobileShowDTO dto) {
        productTagService.setMobileShow(dto.getId(), dto.getMobileShow());
        return Result.success();
    }
}
