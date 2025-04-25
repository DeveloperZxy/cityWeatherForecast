package com.zxy.practiceproject.login.pojo.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserLoginVO {
    private String id;
    private String avatar;
    private String username;
    private String nickname;
    private List<String> roles;
    private List<String> permissions;

    private String accessToken;
    private String refreshToken;
    private Date expires;

}
