package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto;

import lombok.Data;

@Data
public class AmountDetailsVO {

    /**
     * 总商品数量
     */
    private String goodsNum;

    /**
     * 商品总价格
     */
    private String goodsPrice;

    /**
     * 运费
     */
    private String deliveryAmount;

    /**
     * 优惠金额
     */
    private String promotionAmount;

    /**
     * 积分优惠金额
     */
    private String integrationAmount;
    /**
     * VIP优惠金额
     */
    private String vipAmount;

    /**
     * 应付金额
     */
    private String ShouldPayAmount;

}
