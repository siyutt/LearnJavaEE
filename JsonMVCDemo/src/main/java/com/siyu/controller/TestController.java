package com.siyu.controller;

import com.alibaba.fastjson.JSON;
import com.siyu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("testController")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        User user=new User();
        user.setName("siyu");

        return JSON.toJSONString(user);
    }

}
