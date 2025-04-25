package com.zxy.practiceproject.model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping("/test")
    public Map test(){

        Map<String,Object> meters = new HashMap<>();
        meters.put("abc",new Date());
        return meters;
    }
}
