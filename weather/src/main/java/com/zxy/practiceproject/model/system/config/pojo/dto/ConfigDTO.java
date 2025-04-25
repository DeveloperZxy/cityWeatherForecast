package com.zxy.practiceproject.model.system.config.pojo.dto;

import com.zxy.practiceproject.model.system.config.pojo.entity.ConfigEntity;
import lombok.Data;

@Data
public class ConfigDTO extends ConfigEntity {
    private String categoryId;
}
