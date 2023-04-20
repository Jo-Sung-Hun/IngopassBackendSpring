package com.sunrint.ingopass.sunrint_ingopass_backend.Service.NeisService;


import com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.NeisDate;

public interface NeisService {
    String getMeal(NeisDate date);
    String getNotice();

}
