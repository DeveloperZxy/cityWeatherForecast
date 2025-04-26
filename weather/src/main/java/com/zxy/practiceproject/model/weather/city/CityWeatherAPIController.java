package com.zxy.practiceproject.model.weather.city;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.zxy.practiceproject.model.weather.city.pojo.entity.CityEntity;
import com.zxy.practiceproject.model.weather.city.pojo.entity.DaysWeatherEntity;
import com.zxy.practiceproject.model.weather.city.pojo.entity.HoursWeatherEntity;

import java.util.ArrayList;
import java.util.List;

public class CityWeatherAPIController {
    private static final String API_KEY = "425dee2559e7442c9a402f5e3521cfff";
    private static final String HOT_CITIES_API_URL = "https://geoapi.qweather.com/v2/city/top";
    private static final String SEARCH_CITIES_API_URL = "https://geoapi.qweather.com/v2/city/lookup";
    private static final String WEATHER_24H_API_URL = "https://ju62b582xg.re.qweatherapi.com/v7/weather/24h";
    private static final String WEATHER_7DAYS_API_URL = "https://ju62b582xg.re.qweatherapi.com/v7/weather/7d";
    // 替换为你的和风天气API密钥

    /**
     * 获取热门城市列表
     */
    public List<CityEntity> getHotCities() {

        // 构造请求URL
        String url = HOT_CITIES_API_URL + "?key=" + API_KEY;

        // 使用Hutool发送GET请求
        HttpResponse response = HttpRequest.get(url).execute();
        String result = response.body();
        if (response.isOk()) {

            System.out.println("返回结果：" + result);

            // 将结果解析为JSONObject
            JSONObject jsonObject = JSON.parseObject(result);
            // 提取location数组（根据实际API返回的字段名调整）
            JSONArray topCityList = jsonObject.getJSONArray("topCityList");
            System.out.println("返回结果 topCityList: " + topCityList);
            List<CityEntity> cityEntities = JSON.parseArray(topCityList.toJSONString(), CityEntity.class);
            System.out.println("返回结果 topCityList: " + topCityList);
            return cityEntities;
        }
        return new ArrayList<>();
    }

    /**
     * 城市搜索
     */
    public List<CityEntity> searchCity(String query) {
        // 查询条件，可以是城市名称或经纬度
        String url = SEARCH_CITIES_API_URL + "?key=" + API_KEY + "&location=" + query;


        HttpResponse response = HttpRequest.get(url).execute();
        String result = response.body();
        if (response.isOk()) {

            System.out.println("返回结果：" + result);
            // 将结果解析为JSONObject
            JSONObject jsonObject = JSON.parseObject(result);
            // 提取location数组
            JSONArray locationArray = jsonObject.getJSONArray("location");
            List<CityEntity> cityEntities = JSON.parseArray(locationArray.toJSONString(), CityEntity.class);
            System.out.println("返回结果 locationArray: " + locationArray);
            return cityEntities;

        }
        return new ArrayList<>();
    }

    /**
     * 24小时天气预报
     */
    public List<HoursWeatherEntity> oneDayWeather(String locationId) {
        // 查询条件，可以是城市名称或经纬度
        String url = WEATHER_24H_API_URL + "?key=" + API_KEY + "&location=" + locationId;

        HttpResponse response = HttpRequest.get(url).execute();
        String result = response.body();
        if (response.isOk()) {

            System.out.println("返回结果：" + result);
            // 将结果解析为JSONObject
            JSONObject jsonObject = JSON.parseObject(result);
            // 提取location数组
            JSONArray locationArray = jsonObject.getJSONArray("hourly");
            List<HoursWeatherEntity> oneDayWeatherEntities = JSON.parseArray(locationArray.toJSONString(), HoursWeatherEntity.class);
            System.out.println("返回结果 oneDayWeatherEntities: " + oneDayWeatherEntities);
            return oneDayWeatherEntities;

        }
        return new ArrayList<>();
    }

    /**
     * 七天预报
     */
    public List<DaysWeatherEntity> sevenDaysWeather(String locationId) {
        // 查询条件，可以是城市名称或经纬度
        String url = WEATHER_7DAYS_API_URL + "?key=" + API_KEY + "&location=" + locationId;

        HttpResponse response = HttpRequest.get(url).execute();
        String result = response.body();
        if (response.isOk()) {

            System.out.println("返回结果：" + result);
            // 将结果解析为JSONObject
            JSONObject jsonObject = JSON.parseObject(result);
            // 提取location数组
            JSONArray locationArray = jsonObject.getJSONArray("daily");
            List<DaysWeatherEntity> oneDayWeatherEntities = JSON.parseArray(locationArray.toJSONString(), DaysWeatherEntity.class);
            System.out.println("返回结果 oneDayWeatherEntities: " + oneDayWeatherEntities);
            return oneDayWeatherEntities;
        }
        return new ArrayList<>();
    }
}

