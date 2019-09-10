package com.siyu.em.controller;

import com.siyu.em.Util.PageUtil;
import com.siyu.em.entity.Department;
import com.siyu.em.entity.Log;
import com.siyu.em.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class LogController {
    @Autowired
    private LogService logService;

    public void operationLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Log> list=logService.getOperationLog();
        req.setAttribute("List",list);
        req.setAttribute("Type","Operation");
        req.getRequestDispatcher("../log_list.jsp").forward(req,resp);
    }

    public void loginLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Log> list=logService.getLoginLog();

        String index=req.getParameter("page");
        int num=1;
        if(index!=null&&index.trim().length()>0){
            try{
                num=Integer.parseInt(index);
            }catch (Exception e){
            }
        }
        PageUtil pageUtil=logService.getLoginLogPage(num);

//        req.setAttribute("List",list);
        req.setAttribute("Page",pageUtil);
        req.setAttribute("Type","Login");
        req.getRequestDispatcher("../log_list.jsp").forward(req,resp);
    }

    public void systemLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Log> list=logService.getSystemLog();
        req.setAttribute("List",list);
        req.setAttribute("Type","System");
        req.getRequestDispatcher("../log_list.jsp").forward(req,resp);
    }
}
