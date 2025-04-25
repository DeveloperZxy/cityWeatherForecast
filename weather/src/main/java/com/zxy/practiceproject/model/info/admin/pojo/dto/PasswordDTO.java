package com.zxy.practiceproject.model.info.admin.pojo.dto;

import lombok.Data;

@Data
public class PasswordDTO {
    private String id;
    private String oldPassword;
    private String newPasswordOne;
    private String newPasswordTwo;

}
