package com.cuiwei;

import com.cuiwei.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args={"--test.prop=testValue2"},properties = {"test.prop=testValue1"})
public class PropertiesAndArgsTest {
    @Value("${test.prop}")
    private String msg;
    @Autowired
    private BookCase bookCase;
    @Test
    void testProperties(){
        System.out.println(msg);
        System.out.println(bookCase);
    }
}
