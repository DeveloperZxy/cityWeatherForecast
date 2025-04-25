package com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.dto;

import com.zxy.practiceproject.model.user.shop.userShopOrder.pojo.entity.UserShopOrderEntity;
import lombok.Data;

import java.util.List;


@Data
public class UserShopOrderDTO extends UserShopOrderEntity {
    private List<String> cartIds;

    private String addressId;
}
