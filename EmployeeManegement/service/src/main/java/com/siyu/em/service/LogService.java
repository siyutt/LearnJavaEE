package com.siyu.em.service;

import com.siyu.em.Util.PageUtil;
import com.siyu.em.entity.Log;

import java.util.List;

public interface LogService {
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    void addOperationLog(Log log);

    List<Log> getSystemLog();
    List<Log> getLoginLog();
    List<Log> getOperationLog();
    PageUtil getLoginLogPage(int num);
}
