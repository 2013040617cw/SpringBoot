package com.cuiwei.service;


import com.cuiwei.domain.SMSCode;

public interface SMSCodeService {
    public String sendCodeToSMS(String tele);
    public boolean checkCode(SMSCode smsCode);
}
