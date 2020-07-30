package com.example.helloservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.helloservice.controller.HttpClientUtil;
import com.example.helloservice.controller.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class HelloServiceApplicationTests {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    void contextLoads() {
    }
    @Test
    public void test1(){
       ResponseEntity<String> forEntity = restTemplate.getForEntity("http://hello-service2/testService2", String.class);
        System.out.println(forEntity.getBody());
    }
    @Test
    public void test2(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8091/testService3", String.class);
        System.out.println(forEntity.getBody());
    }
    @Test
    public void test3() {
        try {
            String s = HttpClientUtil.doGet("http://localhost:8091/testService3", null);
            System.out.println(s);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Test
    public void test4() {
        String s = HttpClientUtil.doGet("http://localhost:8090/testService2", null);
        System.out.println(s);
    }
    @Test
    public void test5() {
        ResponseEntity<String> rs = restTemplate.getForEntity("http://hello-service2/test2?name={1}", String.class, "张三");
        String body = rs.getBody();
        System.out.println(body);
    }
    @Test
    public void test6() {
        Map map=new HashMap<>();
        map.put("name","张三");
        map.put("age",11);
        ResponseEntity<String> rs = restTemplate.getForEntity("http://hello-service2/test6?name={name}&age={age}", String.class,"张三",21);
        String body = rs.getBody();
        System.out.println(body);
    }

    @Test
    public void test7() {
        Map map=new HashMap<>();
        map.put("name","张三");
        map.put("age","11");
        String s = HttpClientUtil.doGet("http://localhost:8090/test6", map);
        System.out.println(s);
    }

    @Test
    public void test8() {
        Map map=new HashMap<>();
        map.put("name","张三");
        map.put("age",11);
        ResponseEntity<String> rs = restTemplate.getForEntity("http://hello-service2/test6?name={name}&age={age}", String.class,"张三",21);
        String body = rs.getBody();
        System.out.println(body);
    }

    @Test
    public void test9() {
        Map map=new HashMap<>();
        Student student=new Student();
        student.setAge(21);
        student.setName("李四");
        Object o = JSON.toJSON(student);
        String s1 = o.toString();
        map.put("name","张三");
        map.put("age","11");
        String s = HttpClientUtil.doGet("http://localhost:8090/test3",map);
        Student student1 = JSONObject.parseObject(s, Student.class);
        System.out.println(student1.getName());
    }



}
