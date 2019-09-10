package com.siyu.em.service;

import com.siyu.em.entity.Staff;

import javax.swing.*;
import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void edit(Staff staff);
    void remove(Integer id);
    Staff get(Integer id);
    List<Staff> getAll();
}
