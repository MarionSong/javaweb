package com.marion.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(){
        return "hello world";
    }


    @RequestMapping("/success")
    public String Success(Map<String,Object> map){
        map.put("hello","<h1>张三</h1>");
        map.put("user", Arrays.asList("张三","李四","王五"));
        return "success";
    }


}
