package com.siyu.em.controller;

import com.siyu.em.entity.Staff;
import com.siyu.em.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;
    //toLogin.do
    public void toLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
    //login.do
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String account=req.getParameter("account");
        String password=req.getParameter("password");

        Staff staff=loginService.login(account,password);
        if(staff==null)
            resp.sendRedirect("toLogin.do");
        else{
//            System.out.println("Login Sucess!");
            HttpSession session=req.getSession();
            session.setAttribute("User",staff);
            resp.sendRedirect("main.do");
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        session.setAttribute("User",null);
        resp.sendRedirect("toLogin.do");
    }

    public void main(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("User",req.getSession().getAttribute("User"));
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    public void info(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../info.jsp").forward(req,resp);
    }

    public void toChangePassword(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("../change_password.jsp").forward(req,resp);
    }

    public void changePassword(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String password=req.getParameter("password");
        String newPassword=req.getParameter("newPassword");
        Staff staff=(Staff) req.getSession().getAttribute("User");
        if(password.equals(staff.getPassword())) {
            loginService.changePassword(staff.getId(),newPassword);
//            resp.sendRedirect("../logout.jsp");
            resp.getWriter().write("<script type=\"text/javascript\" >parent.location.href=\"../logout.do\"</script>");
        }
        else
            resp.sendRedirect("toChangePassword.do");
    }
}
