package com.example.helloservice3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xin.you
 * @date 2020/7/30
 * @description test
 */
@Controller
public class HellowController {
    @GetMapping("/testService3")
    @ResponseBody
    public String testService3(){
        return "this is testService3";
    }
}
