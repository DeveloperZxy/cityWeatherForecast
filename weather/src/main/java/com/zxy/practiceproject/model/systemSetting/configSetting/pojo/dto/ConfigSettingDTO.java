package com.zxy.practiceproject.model.systemSetting.configSetting.pojo.dto;

import com.zxy.practiceproject.model.systemSetting.configSetting.pojo.entity.ConfigSettingEntity;
import lombok.Data;

@Data
public class ConfigSettingDTO  {

    private String netName;
    private String netAddress;
    private String phone;
    private String netCacheTime;
    private String netRecordNumber;

}
