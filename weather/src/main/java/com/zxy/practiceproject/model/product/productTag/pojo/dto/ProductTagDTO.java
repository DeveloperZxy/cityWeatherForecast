package com.zxy.practiceproject.model.product.productTag.pojo.dto;

import com.zxy.practiceproject.model.product.productTag.pojo.entity.ProductTagEntity;
import lombok.Data;

@Data
public class ProductTagDTO extends ProductTagEntity {
    private String categoryId;
}
