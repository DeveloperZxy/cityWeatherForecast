package com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto;

import com.zxy.practiceproject.model.user.shop.userShopCart.pojo.entity.UserShopCartEntity;
import lombok.Data;

@Data
public class UserShopCartDTO {
    private String id;
    private String productId;
    private String productDetailsId;
    private String num;

}
