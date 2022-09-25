package com.cuiwei.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceimpl2 implements com.cuiwei.SendMailService {

    @Resource
    private JavaMailSender javaMailSender;
    //发送人
    private String from = " 1477367132@qq.com";

    //接收人
    private String to = "705040525@qq.com";

    //标题
    private String subject = "测试文件";
    //正文

    private String context = "<a href = 'http://www.itcast.cn'>点开有惊喜</a>";
    @Override
    public void senMail() {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom(from + "小崔崔");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context,true);
            javaMailSender.send(message);

            //添加附件
            File f1 = new File("D:\\SpringBootProject\\springboot_18_mail\\target\\springboot_18_mail-0.0.1-SNAPSHOT.jar");

            helper.addAttachment(f1.getName(),f1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
