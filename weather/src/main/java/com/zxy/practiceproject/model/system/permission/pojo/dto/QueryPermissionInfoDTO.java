package com.zxy.practiceproject.model.system.permission.pojo.dto;

import com.zxy.common.pojo.entity.QueryEntity;
import lombok.Data;

@Data
public class QueryPermissionInfoDTO extends QueryEntity {
    /**
     * 是否包含Root    0为不包含Root ，1为包含Root
     */
    private String  includeRoot;


}
