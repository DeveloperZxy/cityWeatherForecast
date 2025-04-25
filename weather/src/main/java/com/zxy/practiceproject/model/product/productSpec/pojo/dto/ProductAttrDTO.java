package com.zxy.practiceproject.model.product.productSpec.pojo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductAttrDTO {
    private String name;
    private List<String> attributes;

}
