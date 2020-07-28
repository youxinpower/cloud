package com.example.helloservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xin.you
 * @date 2020/7/21
 * @description 测试
 */
@Controller
public class HellowController {
    @GetMapping("/hello")
    public String hello(){
        return "/index";
    }
}
