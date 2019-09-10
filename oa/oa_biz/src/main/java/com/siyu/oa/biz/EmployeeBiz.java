package com.siyu.oa.biz;

import com.siyu.oa.entity.Department;
import com.siyu.oa.entity.Employee;

import java.util.List;

public interface EmployeeBiz {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
