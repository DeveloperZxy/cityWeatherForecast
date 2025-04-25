package com.zxy.practiceproject.model.crm.user.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;


@Data
@TableName(value = "crm_user_info", autoResultMap = true)
public class UserEntity extends CoreEntity {
    private String categoryId;
    private String username;
    private String phone;
    //用户等级
    private String userGrade;
    private String isGroup;

    //余额
    private String balance;
    //推荐人
    private String recommender;
    //是否是会员
    private String isVip;
    //身份证号
    private String idNumber;
    //性别
    private String sex;
    //生日
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;
    //住址
    private String address;

    //登陆密码
    private String password;
    @TableField(value = "`roles`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> roles;


}
