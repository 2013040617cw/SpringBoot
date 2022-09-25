package com.cuiwei.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service
public class SendMailServiceimpl implements com.cuiwei.SendMailService {

    @Resource
    private JavaMailSender javaMailSender;
    //发送人
    private String from = " 1477367132@qq.com";

    //接收人
    private String to = "705040525@qq.com";

    //标题
    private String subject = "测试文件";
    //正文

    private String context = "我爱你，就像老鼠爱大米";
    @Override
    public void senMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
