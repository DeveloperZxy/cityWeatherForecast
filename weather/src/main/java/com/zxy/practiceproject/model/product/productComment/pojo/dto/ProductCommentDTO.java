package com.zxy.practiceproject.model.product.productComment.pojo.dto;

import com.zxy.practiceproject.model.product.productComment.pojo.entity.ProductCommentEntity;
import lombok.Data;

@Data
public class ProductCommentDTO extends ProductCommentEntity {
    private String categoryId;
}
