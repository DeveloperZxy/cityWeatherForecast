package com.zxy.practiceproject.model.systemSetting.configSetting.service;

import com.zxy.practiceproject.model.systemSetting.configSetting.pojo.dto.ShowConfigSettingDTO;

public interface ConfigSettingService {

    ShowConfigSettingDTO show();

    void save(ShowConfigSettingDTO dto);
}
