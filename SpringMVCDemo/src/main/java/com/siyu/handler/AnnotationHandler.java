package com.siyu.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AnnotationHandler {

    @RequestMapping("/siyu")
    public ModelAndView modelAndViewTest(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","Siyu");
        modelAndView.setViewName("show");
        return modelAndView;
    }

    @RequestMapping("/model")
    public String modelTest(Model model){
        model.addAttribute("name","asdqwehs");
        return "show";
    }

    @RequestMapping("/map")
    public String mapTest(Map<String,String> map){
        map.put("name","mapTest");
        return "show";
    }
}
