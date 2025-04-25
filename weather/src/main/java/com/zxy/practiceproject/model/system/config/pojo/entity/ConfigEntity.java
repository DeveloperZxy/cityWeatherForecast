package com.zxy.practiceproject.model.system.config.pojo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zxy.common.pojo.entity.CoreEntity;
import lombok.Data;



@Data
@TableName(value = "system_config_info", autoResultMap = true)
public class ConfigEntity extends CoreEntity {
       private String categoryId;
       private String value;
}
