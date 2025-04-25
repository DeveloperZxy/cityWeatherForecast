package com.zxy.practiceproject.model.user.shop.productInfo.pojo.dto;

import com.zxy.practiceproject.model.user.shop.productInfo.pojo.entity.ProductRecordEntity;
import lombok.Data;

@Data
public class ProductRecordDTO extends ProductRecordEntity {
    private String categoryId;
}
