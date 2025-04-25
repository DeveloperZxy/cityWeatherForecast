package com.zxy.practiceproject.model.crm.userTag.pojo.dto;

import com.zxy.practiceproject.model.crm.userTag.pojo.entity.UserTagEntity;
import lombok.Data;

@Data
public class UserTagDTO extends UserTagEntity {
    private String categoryId;
}
