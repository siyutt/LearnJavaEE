package com.siyu.em.service.impl;

import com.siyu.em.dao.StaffDao;
import com.siyu.em.entity.Staff;
import com.siyu.em.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    public void add(Staff staff) {
//        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("OK");
        staffDao.insert(staff);
    }

    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    public void remove(Integer id) {
        staffDao.delete(id);
    }

    public Staff get(Integer id) {
        return staffDao.selectById(id);
    }

    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}
