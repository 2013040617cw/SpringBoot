package com.cuiwei;

import com.cuiwei.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(MsgConfig.class)
public class ConfigrationTest {
    @Autowired
    private String msg;
    @Test
    void testConfiguration(){
        System.out.println(msg);
    }

}
