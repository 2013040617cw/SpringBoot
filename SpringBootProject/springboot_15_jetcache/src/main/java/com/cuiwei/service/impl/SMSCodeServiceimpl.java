package com.cuiwei.service.impl;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import com.cuiwei.domain.SMSCode;
import com.cuiwei.service.SMSCodeService;
import com.cuiwei.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceimpl implements SMSCodeService {

    @Autowired
    CodeUtils codeUtils;

    @CreateCache(name = "jetcache",expire = 3600)
    private Cache<String,String> jetcache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetcache.put(tele,code);
        return code;
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        String  code = jetcache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }
}
