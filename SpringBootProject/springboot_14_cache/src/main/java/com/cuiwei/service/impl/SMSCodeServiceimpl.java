package com.cuiwei.service.impl;

import com.cuiwei.domain.SMSCode;
import com.cuiwei.service.SMSCodeService;
import com.cuiwei.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class SMSCodeServiceimpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;
    @Autowired
    private MemcachedClient memcachedClient;

//    以下是springboot中使用Xmemcached
    @Override
    public String sendCodeToSMS(String tele) {
        //生成验证码
        String code = codeUtils.generator(tele);
//        将验证码放到memcachedClient
        try {
            memcachedClient.set(tele,0,code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
             code = memcachedClient.get(smsCode.getTele().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return smsCode.getCode().equals(code);
    }
//    @Override
//  @Cacheable(value = "smsCode",key = "#tele")
//    public String sendCodeToSMS(String tele) {
//       String code = codeUtils.generator(tele);
//       return code;
//    }
//
//    @Override
//    public Boolean checkCode(SMSCode smsCode) {
////        //取出内存中的验证码与传递过来的验证码对比。如果相同返回true
////        String code = smsCode.getCode();
////        String cacheCode = codeUtils.get(smsCode.getTele());
//        return null;
//    }






}
