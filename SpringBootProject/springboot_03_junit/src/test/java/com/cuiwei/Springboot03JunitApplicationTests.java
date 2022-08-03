package com.cuiwei;

import com.cuiwei.dao.BootDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03JunitApplicationTests {

    //注入你要测试的对象
    @Autowired
    private BootDao bootDao;
    @Test
    void contextLoads() {
        bootDao.save();
    }
}
