package com.zxy.practiceproject.model.product.productSpec.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zxy.practiceproject.model.product.productSpec.pojo.entity.ProductSpecEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class PageProductSpecDTO extends ProductSpecEntity {

    private List<String> attributes;

    public List<String> getAttributes() {
        List<String> attributes=new ArrayList<>();
        for (ProductAttrDTO attr : getAttrs()) {
            attributes.add(attr.getAttributes().toString());
        }
        return attributes;
    }

    private List<String> names;

    public List<String> getNames() {
        List<String> names=new ArrayList<>();
        for (ProductAttrDTO attr : getAttrs()) {
            names.add(attr.getName());
        }
        return names;
    }
}
