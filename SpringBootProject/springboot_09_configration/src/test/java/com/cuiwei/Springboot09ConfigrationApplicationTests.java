package com.cuiwei;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot09ConfigrationApplicationTests {
    @Value("${servers.ipAddress}")
    private  String msg;
    @Test
    void contextLoads() {
        System.out.println(msg);
    }
}
