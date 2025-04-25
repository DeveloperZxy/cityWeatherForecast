package com.zxy.practiceproject.model.crm.user.pojo.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {
    private String id;
    private String oldPassword;
    private String newPassword;
}
