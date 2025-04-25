package com.zxy.practiceproject.model.user.shop.userShopOrder.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.CartListDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.PageUserShopOrderDetailsDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.UserShopOrderDetailsDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.QueryUserShopOrderDetailsDTO;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderDetailsEntity;
import com.zxy.practiceproject.model.user.shop.userShopOrder.service.UserShopOrderDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/shop/userShopOrderDetails")
@Slf4j
public class UserShopOrderDetailsController {

    @Autowired
    private UserShopOrderDetailsService productBrandService;

    /**
     * 新增
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody CartListDTO cartList) {
        productBrandService.add(cartList);
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
    public Result edit(@RequestBody UserShopOrderDetailsDTO productBrandDTO) {
        productBrandService.edit(productBrandDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<UserShopOrderDetailsDTO> edit(@RequestBody IdDTO idDTO) {
        UserShopOrderDetailsDTO productBrandDTO =  productBrandService.show(idDTO.getId());
        return Result.success(productBrandDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserShopOrderDetailsEntity>> listQuery(@RequestBody QueryUserShopOrderDetailsDTO queryDemoDTO) {
        List<UserShopOrderDetailsEntity> result = productBrandService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询CartoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageUserShopOrderDetailsDTO>> pageQuery(@RequestBody PageQuery<QueryUserShopOrderDetailsDTO> dto) {
        PageResult<PageUserShopOrderDetailsDTO> result = productBrandService.pageQuery(dto);
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
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryUserShopOrderDetailsDTO> dto) {
        List<Tree<String>> result = productBrandService.treeQuery(dto);
        return Result.success(result);
    }

}
