package com.zxy.practiceproject.model.user.shop.userShopCart.pojo.dto;

import com.zxy.common.pojo.entity.QueryEntity;
import lombok.Data;

@Data
public class QueryUserShopCartDTO extends QueryEntity {
    /**
     * 是否包含Root    0为不包含Root ，1为包含Root
     */
    private String  includeRoot;


}
