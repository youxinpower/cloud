package com.example.helloservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author xin.you
 * @date 2020/7/21
 * @description 测试
 */
@Controller
public class HellowController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hello")
    public String hello(){
        return "/index";
    }
    @GetMapping("/test1")
    public void test1(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://hello-service2/testService2", String.class);
        System.out.println(forEntity);
    }

}
