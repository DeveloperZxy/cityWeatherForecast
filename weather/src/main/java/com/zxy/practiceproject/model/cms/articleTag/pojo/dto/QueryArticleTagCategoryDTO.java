package com.zxy.practiceproject.model.cms.articleTag.pojo.dto;

import lombok.Data;

@Data
public class QueryArticleTagCategoryDTO {
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
