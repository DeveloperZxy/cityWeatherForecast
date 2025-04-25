package com.zxy.practiceproject.model.product.productSpec.pojo.dto;

import com.zxy.practiceproject.model.product.productSpec.pojo.entity.ProductSpecEntity;
import lombok.Data;

@Data
public class ProductSpecDTO extends ProductSpecEntity {
    private String categoryId;
}
