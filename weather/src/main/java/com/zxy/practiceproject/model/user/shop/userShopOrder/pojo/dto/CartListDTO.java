package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartListDTO {
    private List<String> cartIds;
    private String orderId;
}
