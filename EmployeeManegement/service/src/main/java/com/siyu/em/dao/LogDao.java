package com.siyu.em.dao;

import com.siyu.em.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("logDao")
public interface LogDao {
    void insert(Log log);
    List<Log> selectByType(String type);
    List<Log> selectByRange(@Param("start") int start, @Param("end") int end);
    Integer getSize();
}
