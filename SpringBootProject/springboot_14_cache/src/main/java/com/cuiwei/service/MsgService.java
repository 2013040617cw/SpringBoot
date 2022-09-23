package com.cuiwei.service;

import org.springframework.stereotype.Service;


public interface MsgService {
    public String get(String tele);
    public boolean check(String tele ,String code);
}
