package com.zxy.practiceproject.model.crm.user.pojo.dto;

import com.zxy.practiceproject.model.crm.user.pojo.entity.UserEntity;
import lombok.Data;

@Data
public class UserDTO extends UserEntity {
    private String categoryId;
}
