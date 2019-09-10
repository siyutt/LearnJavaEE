package com.siyu.oa.controller;

import com.siyu.oa.biz.GlobalBiz;
import com.siyu.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("globalController")
public class globalController {

    @Autowired
    private GlobalBiz globalBiz;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String sn, @RequestParam String password, HttpSession session){
        Employee employee=globalBiz.login(sn,password);
        if(employee==null)
            return "redirect:to_login";
        session.setAttribute("employee",employee);
        return "redirect:self";
    }

    @RequestMapping("/self")
    public String self(){
        return "self";
    }

    @RequestMapping("/quit")
    public String login(HttpSession session){
        session.removeAttribute("employee");
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("/change_password")
    public String login(@RequestParam String old,@RequestParam String new1,@RequestParam String new2, HttpSession session){
        Employee employee=(Employee)session.getAttribute("employee");
        if(employee.getPassword().equals(old)&&new1.equals(new2)){
            employee.setPassword(new1);
            globalBiz.changePassword(employee);
            return "redirect:self";
        }
        return "redirect:to_change_password";
    }

}
