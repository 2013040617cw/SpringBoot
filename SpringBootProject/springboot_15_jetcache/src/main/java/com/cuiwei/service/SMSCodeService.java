package com.cuiwei.service;


import com.cuiwei.doamin.SMSCode;

public interface SMSCodeService {
    public String sendCodeToSMS(String tele);
    public Boolean checkCode(SMSCode smsCode);
}
