package com.cuiwei;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot18MailApplicationTests {
    @Autowired
    private SendMailService sendMailService;

    @Test
    void contextLoads() {
        sendMailService.senMail();
    }

}
