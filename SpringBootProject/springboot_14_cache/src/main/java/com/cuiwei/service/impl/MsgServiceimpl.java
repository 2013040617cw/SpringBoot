package com.cuiwei.service.impl;

import com.cuiwei.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsgServiceimpl implements MsgService {
    private HashMap<String ,String> cache = new HashMap<String,String>();

    @Override
    public String get(String tele) {
        String code = tele.substring(tele.length() - 6);
        cache.put(tele,code);
        return code;
    }

    @Override
    public boolean check(String tele, String code) {
        String queryCode = cache.get(tele);
        return code.equals(queryCode);
    }
}
