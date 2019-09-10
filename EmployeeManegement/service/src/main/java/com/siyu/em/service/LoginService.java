package com.siyu.em.service;

import com.siyu.em.entity.Staff;

public interface LoginService {
    Staff login(String account,String password);
    void changePassword(Integer id,String password);

}
