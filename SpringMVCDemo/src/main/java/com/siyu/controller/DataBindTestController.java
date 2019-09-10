package com.siyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DataBindTestController {

    @RequestMapping("/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "id")Integer id){
        return "id:"+id;
    }


}
