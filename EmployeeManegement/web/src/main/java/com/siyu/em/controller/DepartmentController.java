package com.siyu.em.controller;

import com.siyu.em.entity.Department;
import com.siyu.em.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> list=departmentService.getAll();
        req.setAttribute("List",list);
        req.getRequestDispatcher("../department_list.jsp").forward(req,resp);
    }

    public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("../department_add.jsp").forward(req,resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name=req.getParameter("name");
        String address=req.getParameter("address");

        Department department=new Department();
        department.setName(name);
        department.setAddress(address);

        departmentService.add(department);

        resp.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        Department department=departmentService.get(id);
        req.setAttribute("Obj",department);
        req.getRequestDispatcher("../department_edit.jsp").forward(req,resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String address=req.getParameter("address");

        Department department=new Department();
        department.setId(id);
        department.setName(name);
        department.setAddress(address);

        departmentService.edit(department);

        resp.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        departmentService.remove(id);
        resp.sendRedirect("list.do");


    }
}
