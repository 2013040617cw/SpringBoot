package com.cuiwei.service.impl;
import com.cuiwei.domain.SMSCode;
import com.cuiwei.service.SMSCodeService;
import com.cuiwei.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
@Controller
public class SMSCodeServiceimpl implements SMSCodeService {

    @Autowired
    CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
       cacheChannel.set("sms",tele,code);
       return code;
    }
    @Override
    public boolean checkCode(SMSCode smsCode) {
      String code= cacheChannel.get("sms", smsCode.getTele()).asString();
        return smsCode.getCode().equals(code);
    }
}
