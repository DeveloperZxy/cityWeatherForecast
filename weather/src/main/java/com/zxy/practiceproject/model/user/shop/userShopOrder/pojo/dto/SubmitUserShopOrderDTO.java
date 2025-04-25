package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * 提交订单DTO
 */
@Data
public class SubmitUserShopOrderDTO {

    /**
     * 购物车ID列表
     */
    private List<String> cartIdsList;

    /**
     *用户ID
     */
    private String userId;

    /**
     * 地址ID
     */
    private String addressId;
    /**
     * 优惠券ID
     */
    private String couponId;
    //用户留言
    private String remark;


    //积分抵扣的字段
    private String integralPromotionAmount;


}
