package com.zxy.practiceproject;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxy.practiceproject.login.pojo.dto.UserLoginDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeProjectApplicationTests {

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

}
