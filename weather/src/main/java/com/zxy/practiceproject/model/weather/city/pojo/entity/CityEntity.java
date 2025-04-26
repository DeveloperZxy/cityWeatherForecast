package com.zxy.practiceproject.model.weather.city.pojo.entity;

import lombok.Data;

@Data
public class CityEntity {
    private String name;
    private String id;
    private String lat;
    private String lon;
    private String adm2;
    private String adm1;
    private String country;
    private String tz;
    private String utcOffset;
    private String isDst;
    private String type;
    private String rank;
    private String fxLink;
}
