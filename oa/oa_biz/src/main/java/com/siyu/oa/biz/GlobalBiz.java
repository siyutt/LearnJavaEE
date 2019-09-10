package com.siyu.oa.biz;

import com.siyu.oa.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn, String password);
    void changePassword(Employee employee);
}
