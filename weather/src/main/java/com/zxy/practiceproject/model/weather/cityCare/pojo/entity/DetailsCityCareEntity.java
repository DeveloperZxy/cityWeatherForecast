package com.zxy.practiceproject.model.weather.cityCare.pojo.entity;

import com.alibaba.fastjson2.JSONObject;
import com.zxy.practiceproject.model.weather.city.pojo.entity.RealTimeWeatherEntity;
import lombok.Data;

@Data
public class DetailsCityCareEntity extends RealTimeWeatherEntity {
    private String cityName;
    private String locationId;
    private JSONObject locationData;
}
