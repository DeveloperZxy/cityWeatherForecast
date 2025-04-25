package com.zxy.practiceproject.model.crm.userAddress.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Data
@TableName(value = "crm_user_address_info", autoResultMap = true)
public class UserAddrEntity extends CoreEntity {
    @TableField(value = "`category_id`")
    private String categoryId;
    @TableField(value = "`category_ids`", jdbcType = JdbcType.VARCHAR, typeHandler = JacksonTypeHandler.class)
    private List<String> categoryIds;
    @TableField(value = "`user_id`")
    private String userId;
    @TableField(value = "`phone`")
    private String phone;
    @TableField(value = "`province_name`")
    private String provinceName;
    @TableField(value = "`province_code`")
    private String provinceCode;
    @TableField(value = "`city_name`")
    private String cityName;
    @TableField(value = "`city_code`")
    private String cityCode;
    @TableField(value = "`district_name`")
    private String districtName;
    @TableField(value = "`district_code`")
    private String districtCode;
    @TableField(value = "`address_detail`")
    private String addressDetail;

}
