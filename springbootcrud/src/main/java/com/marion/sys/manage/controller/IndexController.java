package com.marion.sys.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {

   /* @RequestMapping({"/","/login.html"})
    public String login(){
        return "login";
    }*/

    @PostMapping("/usr/login")
    public String sign(@RequestParam("username")String username,
                       @RequestParam("password")String password,
                       Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }


    }

}
