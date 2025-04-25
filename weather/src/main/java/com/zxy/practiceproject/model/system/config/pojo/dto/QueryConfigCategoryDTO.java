package com.zxy.practiceproject.model.system.config.pojo.dto;

import lombok.Data;

@Data
public class QueryConfigCategoryDTO {
    /**
     * 是否包含Root    0为不包含Root ，1为包含Root
     */
    private String  includeRoot;

    /**
     * 上级分类ID
     */
    private String parentId;

    private String name;


}
