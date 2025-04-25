package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * 订单详情
 */
@Data
public class OrderDetailsVO {
    private String orderNumber;
    private String orderPrice;
    private String receiveAddress;
    private List<String> orderNames;
}
