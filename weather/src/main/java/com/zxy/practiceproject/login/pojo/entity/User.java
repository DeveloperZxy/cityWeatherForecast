package com.zxy.practiceproject.login.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
public class User extends CoreEntity {

    @JsonIgnore
    private String password;
    private String username;

}
