package com.zxy.practiceproject.model.systemSetting.configSetting.pojo.entity;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
//@TableName(value = "system_config_info", autoResultMap = true)
public class ConfigSettingEntity extends CoreEntity {
       private String categoryId;
       private String value;
}
