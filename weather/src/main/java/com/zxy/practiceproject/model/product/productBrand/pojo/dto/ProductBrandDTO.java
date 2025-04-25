package com.zxy.practiceproject.model.product.productBrand.pojo.dto;

import com.zxy.practiceproject.model.product.productBrand.pojo.entity.ProductBrandEntity;
import lombok.Data;

@Data
public class ProductBrandDTO extends ProductBrandEntity {
    private String categoryId;
}
