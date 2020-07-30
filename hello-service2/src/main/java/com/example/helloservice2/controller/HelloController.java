package com.example.helloservice2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xin.you
 * @date 2020/7/30
 * @description 测试
 */
@Controller
public class HelloController {
    @GetMapping("/testService2")
    @ResponseBody
    public String testService2(){
    return "this is a test";
    }
    @GetMapping("/test2")
    @ResponseBody
    public String testString(String name){
        return "this is:"+name;
    }

    @GetMapping("/test6")
    @ResponseBody
    public String test6(String name,Integer age){
        return "this is:"+name+",age="+age;
    }

    @GetMapping("/test3")
    @ResponseBody
    public Student test3(Student student){
        return student;
    }
    @GetMapping("/test4")
    @ResponseBody
    public int test4(Long[] ids){
        return ids.length;
    }

}
