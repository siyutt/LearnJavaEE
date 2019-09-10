package com.siyu.em.controller;

import com.siyu.em.entity.Department;
import com.siyu.em.entity.Staff;
import com.siyu.em.service.DepartmentService;
import com.siyu.em.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Staff> list=staffService.getAll();
        req.setAttribute("List",list);
        req.getRequestDispatcher("../staff_list.jsp").forward(req,resp);
    }

    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> list=departmentService.getAll();
        req.setAttribute("DList",list);
        req.getRequestDispatcher("../staff_add.jsp").forward(req,resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String account=req.getParameter("account");
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        String idNumber=req.getParameter("idNumber");
        String info=req.getParameter("info");
        Date bornDate=null;
        try{
            bornDate=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("bornDate"));
        }catch (ParseException e){
            e.printStackTrace();
        }
        Integer did=Integer.parseInt(req.getParameter("did"));

        Staff staff=new Staff();
        staff.setName(name);
        staff.setSex(sex);
        staff.setAccount(account);
        staff.setDid(did);
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staff.setInfo(info);
        staffService.add(staff);

        resp.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> list=departmentService.getAll();
        req.setAttribute("DList",list);
        Integer id=Integer.parseInt(req.getParameter("id"));
        Staff staff=staffService.get(id);
        req.setAttribute("Obj",staff);
        req.getRequestDispatcher("../staff_edit.jsp").forward(req,resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer id=Integer.parseInt(req.getParameter("id"));
        String account=req.getParameter("account");
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        String idNumber=req.getParameter("idNumber");
        String info=req.getParameter("info");
        Date bornDate=null;
        try{
            bornDate=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("bornDate"));
        }catch (ParseException e){
            e.printStackTrace();
        }
        Integer did=Integer.parseInt(req.getParameter("did"));

        Staff staff=staffService.get(id);
        staff.setName(name);
        staff.setSex(sex);
        staff.setAccount(account);
        staff.setDid(did);
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staff.setInfo(info);

        staffService.edit(staff);

        resp.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        staffService.remove(id);
        resp.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        Staff staff=staffService.get(id);
        req.setAttribute("Obj",staff);
        req.getRequestDispatcher("../staff_detail.jsp").forward(req,resp);
    }

}
