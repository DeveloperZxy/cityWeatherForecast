package com.zxy.practiceproject;

import cn.hutool.core.date.DateUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zxy"})
@MapperScan({"com.zxy.practiceproject.**.**.mapper"})
public class PracticeProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeProjectApplication.class, args);
    }

}
