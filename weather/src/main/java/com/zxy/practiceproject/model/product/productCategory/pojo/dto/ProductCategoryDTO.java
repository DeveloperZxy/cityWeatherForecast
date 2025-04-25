package com.zxy.practiceproject.model.product.productCategory.pojo.dto;

import com.zxy.practiceproject.model.product.productCategory.pojo.entity.ProductCategoryEntity;
import lombok.Data;

@Data
public class ProductCategoryDTO extends ProductCategoryEntity {
    private String categoryId;
}
