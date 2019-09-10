package com.siyu.oa.dto;

import com.siyu.oa.entity.ClaimVoucher;
import com.siyu.oa.entity.ClaimVoucherItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClaimVoucherInfo {

    private ClaimVoucher claimVoucher;
    private List<ClaimVoucherItem> items;

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public List<ClaimVoucherItem> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucherItem> items) {
        this.items = items;
    }
}
