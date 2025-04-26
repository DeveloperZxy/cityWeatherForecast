package com.zxy.practiceproject.model.weather.city.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RealTimeWeatherEntity {

    /**
     * 观测时间
     */
    private Date obsTime;

    /**
     * 温度（摄氏度）
     */
    private Integer temp;

    /**
     * 体感温度（摄氏度）
     */
    private Integer feelsLike;

    /**
     * 天气图标代码
     */
    private String icon;

    /**
     * 天气文本描述
     */
    private String text;

    /**
     * 风向（度）
     */
    private Integer wind360;

    /**
     * 风向文本描述
     */
    private String windDir;

    /**
     * 风力等级
     */
    private String windScale;

    /**
     * 风速（公里/小时）
     */
    private Integer windSpeed;

    /**
     * 相对湿度（百分比）
     */
    private Integer humidity;

    /**
     * 降水量（毫米）
     */
    private Double precip;

    /**
     * 气压（百帕）
     */
    private Integer pressure;

    /**
     * 能见度（公里）
     */
    private Integer vis;

    /**
     * 云量（百分比）
     */
    private Integer cloud;

    /**
     * 露点温度（摄氏度）
     */
    private Integer dew;
}
