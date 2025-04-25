package com.zxy.practiceproject.model.user.shop.userShopOrder.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.common.pojo.dto.IdDTO;
import com.zxy.common.pojo.dto.TreeQueryDTO;
import com.zxy.common.result.PageQuery;
import com.zxy.common.result.PageResult;
import com.zxy.practiceproject.model.crm.userAddress.pojo.dto.UserAddrDTO;
import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto.*;
import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderEntity;

import java.math.BigDecimal;
import java.util.List;

public interface UserShopOrderService extends IService<UserShopOrderEntity> {
    /**
     * 新增
     *
     * @param
     * @return
     */
    void addOrSubmitOrder(SubmitUserShopOrderDTO submitUserShopOrderDTO);

    /**
     * 删除
     *
     * @param
     * @return
     */
    void deleteOneById(String Id);


    /**
     * 编辑
     * @param userShopOrderDTO
     * @return
     */
    void edit(UserShopOrderDTO userShopOrderDTO);

    /**
     * 列表查询
     *
     * @param
     * @return 包含查询结果的响应体R，其中List<COnfigEntity>为查询结果列表
     */
    List<UserShopOrderEntity> listQuery(QueryUserShopOrderDTO queryConfigDTO);

    /**
     * 分页查询
     * @param dto
     * @return
     */
    PageResult<PageUserShopOrderDTO> pageQuery(PageQuery<QueryUserShopOrderDTO> dto );

    /**
     * 根据id详情查询
     * @param id
     * @return
     */
    UserShopOrderDTO show(String id);

    /**
     * 设置状态
     * @param id
     * @param status
     */
    void setStatus(String id, Integer status);


    /**
     * 树形查询
     *
     * @param dto 包含查询条件的DTO对象，可以为空
     * @return 包含树形结构的List<Tree<String>>类型的响应结果R
     */
    List<Tree<String>> treeQuery(TreeQueryDTO<QueryUserShopOrderDTO> dto);

    public List<String> listChildrenIdsAndSelf(String id);

    /**
     * 用户购物车列表
     *
     * @param
     * @return
     */

    List<UserShopOrderEntity> getUserOrdersList(IdDTO idDTO);

    /**
     * 用户购物车修改数量
     *
     * @param
     * @return
     */
    void updateOrderNum(UserShopOrderDTO userShopOrderDTO);

    void deleteAllById(String id);

    /**
     * 订单详情
     *
     * @param
     * @return
     */
    OrderDetailsVO getOrderDetails(UserShopOrderDTO userShopOrderDTO);

    /**
     * 确定订单  confirmOrder
     *
     * @param
     * @return
     */
    ConfirmOrderVO confirmOrder(List<String> cartIdsList);

    /**
     * 计算金额  calculateAmount
     *
     * @param
     * @return
     */
    AmountDetailsVO calculateAmount(SubmitUserShopOrderDTO submitUserShopOrderDTO);
}
