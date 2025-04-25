package com.zxy.practiceproject.model.systemSetting.configSetting.controller;

import com.zxy.common.pojo.dto.IdStatusDTO;
import com.zxy.common.result.Result;
import com.zxy.practiceproject.model.systemSetting.configSetting.pojo.dto.ShowConfigSettingDTO;
import com.zxy.practiceproject.model.systemSetting.configSetting.service.ConfigSettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/systemSetting/configSetting")
@Slf4j
public class ConfigSettingController {

    @Autowired
    private ConfigSettingService configSettingService;

    /**
     * 返回
     *
     * @param
     * @return 通用响应结果R，包含操作结果和消息
     */
    @PostMapping(value = {"/show"})
    public Result<ShowConfigSettingDTO> show() {
        ShowConfigSettingDTO show = configSettingService.show();
        return Result.success(show);
    }

    /**
     * 更新，保存
     *
     * @param
     * @return 通用响应结果R，包含操作结果和消息
     */
    @PostMapping(value = {"/save"})
    public Result save(@RequestBody ShowConfigSettingDTO dto) {
        configSettingService.save(dto);
        return Result.success();
    }

}
