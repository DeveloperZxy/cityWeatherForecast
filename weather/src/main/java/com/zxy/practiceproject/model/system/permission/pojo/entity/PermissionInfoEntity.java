package com.zxy.practiceproject.model.system.permission.pojo.entity;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "system_permission_info", autoResultMap = true)
public class PermissionInfoEntity extends CoreEntity {

    private String categoryId;
    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;

    //路由
    private String path;
    //路由元信息
    @TableField(value = "`meta`",jdbcType = JdbcType.VARCHAR, typeHandler = FastjsonTypeHandler.class)
    private PermissionMeta meta;
    private String component;
    private String redirect;

}
