package com.zxy.practiceproject.model.weather.city.pojo.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "city_info", autoResultMap = true)
public class CityInfoEntity extends CoreEntity {
    @TableField(value = "`category_id`")
    private String categoryId;
    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
    @TableField(value = "`location_data`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private JSONObject locationData;
    @TableField(value = "`location_id`")
    private String locationId;
    @TableField(value = "`warn`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private JSONObject warn;
}
