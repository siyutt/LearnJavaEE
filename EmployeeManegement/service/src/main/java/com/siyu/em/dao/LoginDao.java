package com.siyu.em.dao;

import com.siyu.em.entity.Staff;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
public interface LoginDao {
    Staff selectByAccount(String account);
}
