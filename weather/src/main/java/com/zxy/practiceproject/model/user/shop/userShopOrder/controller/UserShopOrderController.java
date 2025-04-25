package com.zxy.practiceproject.model.user.shop.userShopOrder.controller;

import cn.hutool.core.lang.tree.Tree;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.common.result.Result;
import com.zxy.common.utils.JwtUtil;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.UserAddrDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.*;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderEntity;
import com.zxy.practiceproject.model.user.shop.userShopOrder.service.UserShopOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user/shop/userShopOrderInfo")
@Slf4j
public class UserShopOrderController {

    @Autowired
    private UserShopOrderService userShopOrderService;

    /**
     * 新增购物车到订单中
     *
     * @param
     * @return
     */
    @PostMapping("/add")
    public Result addOrSubmitOrder(@RequestBody SubmitUserShopOrderDTO submitUserShopOrderDTO) {
        userShopOrderService.addOrSubmitOrder(submitUserShopOrderDTO);
        return Result.success();
    }

    /**
     * 返回订单详情
     *
     * @param
     * @return
     */
    @PostMapping("/getOrderDetails")
    public Result<OrderDetailsVO> getOrderDetails(@RequestBody UserShopOrderDTO userShopOrderDTO) {
        OrderDetailsVO orderDetailsVO = userShopOrderService.getOrderDetails(userShopOrderDTO);
        return Result.success(orderDetailsVO);
    }

    /**
     * 确定订单  confirmOrder
     *
     * @param
     * @return
     */
    @PostMapping("/confirmOrder")
    public Result<ConfirmOrderVO> confirmOrder(@RequestBody CartListDTO cartListDTO) {
        ConfirmOrderVO result= userShopOrderService.confirmOrder(cartListDTO.getCartIds());
        return Result.success(result);
    }

    /**
     * 计算金额  calculateAmount
     *
     *
     * @param
     * @return
     */
    @PostMapping("/calculateAmount")
    public Result<AmountDetailsVO> calculateAmount(@RequestBody SubmitUserShopOrderDTO submitUserShopOrderDTO) {
        AmountDetailsVO result =  userShopOrderService.calculateAmount(submitUserShopOrderDTO);
        return Result.success(result);
    }


    /**
     * 删除某用户全部订单
     *
     * @param
     * @return
     */
    @PostMapping("/del")
    public Result deleteOneById(@RequestBody IdDTO idDTO) {
        userShopOrderService.deleteOneById(idDTO.getId());
        return Result.success();
    }

    /**
     * 编辑
     *
     * @param userShopOrderDTO
     * @return
     */
    @PostMapping("/edit")
    public Result edit(@RequestBody UserShopOrderDTO userShopOrderDTO) {
        userShopOrderService.edit(userShopOrderDTO);
        return Result.success();
    }


    /**
     * 查询
     */
    @PostMapping("/show")
    public Result<UserShopOrderDTO> edit(@RequestBody IdDTO idDTO) {
        UserShopOrderDTO userShopOrderDTO = userShopOrderService.show(idDTO.getId());
        return Result.success(userShopOrderDTO);
    }

    /**
     * 列表查询
     *
     * @param
     */
    @PostMapping("/list")
    public Result<List<UserShopOrderEntity>> listQuery(@RequestBody QueryUserShopOrderDTO queryDemoDTO) {
        List<UserShopOrderEntity> result = userShopOrderService.listQuery(queryDemoDTO);
        return Result.success(result);
    }

    /**
     * 分页查询OrderoonInfo信息
     */
    @PostMapping("/page")
    public Result<PageResult<PageUserShopOrderDTO>> pageQuery(@RequestBody PageQuery<QueryUserShopOrderDTO> dto) {
        PageResult<PageUserShopOrderDTO> result = userShopOrderService.pageQuery(dto);
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
        userShopOrderService.setStatus(dto.getId(), dto.getStatus());
        return Result.success();
    }

    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree < String>>类型的响应结果R
     */
    @PostMapping("/tree")
    public Result<List<Tree<String>>> treeQuery(@RequestBody TreeQueryDTO<QueryUserShopOrderDTO> dto) {
        List<Tree<String>> result = userShopOrderService.treeQuery(dto);
        return Result.success(result);
    }

}
