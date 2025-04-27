package com.zxy.practiceproject.model.weather.cityCare.pojo.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "crm_user_city_care", autoResultMap = true)
public class CityCareInfoEntity extends CoreEntity {
    @TableField(value = "`category_id`")
    private String categoryId;
    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
    @TableField(value = "`user_id`")
    private String userId;
    @TableField(value = "`city_id`")
    private String cityId;
}
