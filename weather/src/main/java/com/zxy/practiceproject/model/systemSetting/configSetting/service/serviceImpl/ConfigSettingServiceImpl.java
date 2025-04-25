package com.zxy.practiceproject.model.systemSetting.configSetting.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.practiceproject.model.system.config.service.ConfigService;
import com.zxy.practiceproject.model.systemSetting.configSetting.mapper.ConfigSettingMapper;
import com.zxy.practiceproject.model.systemSetting.configSetting.pojo.dto.ShowConfigSettingDTO;
import com.zxy.practiceproject.model.systemSetting.configSetting.pojo.entity.ConfigSettingEntity;
import com.zxy.practiceproject.model.systemSetting.configSetting.service.ConfigSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigSettingServiceImpl extends ServiceImpl<ConfigSettingMapper, ConfigSettingEntity> implements ConfigSettingService {
    @Autowired
    private ConfigSettingMapper configMapper;

    @Autowired
    private ConfigService configService;
    private String netNameCode = "SystemSetting.Sys.NetName";
    private String phoneCode = "SystemSetting.Sys.Phone";
    private String netAddressCode = "SystemSetting.Sys.NetAddress";
    private String netCacheTimeCode = "SystemSetting.Sys.NetCacheTime";
    private String netRecordNumberCode = "SystemSetting.Sys.NetRecordNumber";


    @Override
    public ShowConfigSettingDTO show() {
        ShowConfigSettingDTO showConfigSettingDTO = new ShowConfigSettingDTO();
        //赋值
        showConfigSettingDTO.setNetAddress(configService.getValueByCode(netAddressCode));
        showConfigSettingDTO.setNetName(configService.getValueByCode(netNameCode));
        showConfigSettingDTO.setNetCacheTime(configService.getValueByCode(netCacheTimeCode));
        showConfigSettingDTO.setNetRecordNumber(configService.getValueByCode(netCacheTimeCode));
        showConfigSettingDTO.setPhone(configService.getValueByCode(phoneCode));
        //返回
        return showConfigSettingDTO;
    }

    @Override
    public void save(ShowConfigSettingDTO dto) {
        configService.setValueByCode(netRecordNumberCode, dto.getNetRecordNumber());
        configService.setValueByCode(netCacheTimeCode, dto.getNetCacheTime());
        configService.setValueByCode(netAddressCode, dto.getNetAddress());
        configService.setValueByCode(phoneCode, dto.getPhone());
        configService.setValueByCode(netNameCode, dto.getNetName());
    }
}
