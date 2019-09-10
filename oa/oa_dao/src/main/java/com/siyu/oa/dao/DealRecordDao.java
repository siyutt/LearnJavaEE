package com.siyu.oa.dao;

import com.siyu.oa.entity.DealRecord;
import com.siyu.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("dealRecordDao")
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    List<DealRecord> selectByClaimVoucher(int cvid);
}
