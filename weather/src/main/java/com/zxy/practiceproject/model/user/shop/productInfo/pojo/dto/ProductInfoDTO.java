package com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto;

import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductInfoEntity;
import lombok.Data;

@Data
public class ProductInfoDTO extends ProductInfoEntity {
    private String categoryId;
}
