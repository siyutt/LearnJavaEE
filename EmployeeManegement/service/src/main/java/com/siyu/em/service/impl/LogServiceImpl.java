package com.siyu.em.service.impl;

import com.siyu.em.Util.PageUtil;
import com.siyu.em.dao.LogDao;
import com.siyu.em.entity.Log;
import com.siyu.em.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    public void addSystemLog(Log log) {
        log.setOprTime(new Date());
        log.setType("system");
        logDao.insert(log);
    }

    public void addLoginLog(Log log) {
        log.setOprTime(new Date());
        log.setType("login");
        logDao.insert(log);
    }

    public void addOperationLog(Log log) {
        log.setOprTime(new Date());
        log.setType("operation");
        logDao.insert(log);
    }

    public List<Log> getSystemLog() {
        return logDao.selectByType("system");
    }

    public List<Log> getLoginLog() {
        return logDao.selectByType("login");
    }

    public List<Log> getOperationLog() {
        return logDao.selectByType("operation");
    }

    public PageUtil getLoginLogPage(int num) {
        PageUtil page=new PageUtil(num,logDao.getSize());
        page.setResultList(logDao.selectByRange(page.getIndex(),page.getPageSize()));
        return page;
    }
}
