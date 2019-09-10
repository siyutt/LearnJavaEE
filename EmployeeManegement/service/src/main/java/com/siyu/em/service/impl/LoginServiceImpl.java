package com.siyu.em.service.impl;

import com.siyu.em.dao.LoginDao;
import com.siyu.em.dao.StaffDao;
import com.siyu.em.entity.Staff;
import com.siyu.em.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;
    @Autowired
    private StaffDao staffDao;

    public Staff login(String account, String password) {
        Staff staff=loginDao.selectByAccount(account);
        if(staff==null) return null;
        if(staff.getPassword().equals(password))
            return staff;
        return null;
    }

    public void changePassword(Integer id, String password) {
        Staff staff=staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
