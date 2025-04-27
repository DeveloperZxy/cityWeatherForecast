package com.zxy.practiceproject;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxy.practiceproject.login.pojo.dto.UserLoginDTO;
import com.zxy.practiceproject.model.weather.city.CityWeatherAPIController;
import com.zxy.practiceproject.model.weather.city.pojo.entity.CityEntity;
import com.zxy.practiceproject.model.weather.city.pojo.entity.DaysWeatherEntity;
import com.zxy.practiceproject.model.weather.city.pojo.entity.HoursWeatherEntity;
import com.zxy.practiceproject.model.weather.cityCare.pojo.dto.QueryCityCareInfoDTO;
import com.zxy.practiceproject.model.weather.cityCare.pojo.entity.DetailsCityCareEntity;
import com.zxy.practiceproject.model.weather.cityCare.service.CityCareInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PracticeProjectApplicationTests {
@Autowired private CityCareInfoService cityCareInfoService;
    public void index2(){
        /**
         * []
         * {}
         */

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");

//        JSON
//        JSON.toJSONString()
    }

    /**
     * 阿里FastJSON
     * SpringBoot默认使用的jackson
     * @throws Exception
     */
    @Test
    void contextLoads() throws Exception {
        String jsonStr="{\n" +
                "   \"username\":\"admin\",\n" +
                "   \"password\":\"123456\" \n" +
                "}";


        ObjectMapper objectMapper = new ObjectMapper();
        UserLoginDTO userLoginDTO = objectMapper.readValue(jsonStr, UserLoginDTO.class);




        String jsonString = objectMapper.writeValueAsString(userLoginDTO);
        System.out.println(jsonString);

    }

    @Test
    public void testCityApi(){

        //测试一下城市接口
        CityWeatherAPIController   cityWeatherAPIController = new CityWeatherAPIController();
//        cityWeatherAPIController.getHotCities();
//          cityWeatherAPIController.searchCity("北京");
//          cityWeatherAPIController.oneDayWeather("101010100");
//          cityWeatherAPIController.sevenDaysWeather("101010100");
          cityWeatherAPIController.realTimeWeather("101010100");

//        // 测试一下城市接口
//        CityWeatherAPIController cityWeatherAPIController = new CityWeatherAPIController();
//
//        // 获取热门城市列表
//        List<CityEntity> hotCities = cityWeatherAPIController.getHotCities();
//        System.out.println("热门城市列表: " + hotCities);
//
//        // 搜索城市
//        List<CityEntity> searchCities = cityWeatherAPIController.searchCity("北京");
//        System.out.println("搜索城市结果: " + searchCities);
//
//        // 24小时天气预报
//        List<HoursWeatherEntity> oneDayWeather = cityWeatherAPIController.oneDayWeather("101010100");
//        System.out.println("24小时天气预报: " + oneDayWeather);
//
//        // 7天天气预报
//        List<DaysWeatherEntity> sevenDaysWeather = cityWeatherAPIController.sevenDaysWeather("101010100");
//        System.out.println("7天天气预报: " + sevenDaysWeather);
    }

    @Test
    public void testCityApi2(){
        QueryCityCareInfoDTO queryCityCareInfoDTO = new QueryCityCareInfoDTO();
        queryCityCareInfoDTO.setUserId("1");
        List<DetailsCityCareEntity> detailsCityCareEntities = cityCareInfoService.listQuery2(queryCityCareInfoDTO);
        System.out.println(detailsCityCareEntities);
    }

}
