package com.cuiwei;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class StringRedisTemplateTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get(){
        ValueOperations<String, String> ops= stringRedisTemplate.opsForValue();
        String name = ops.get("name");
        System.out.println(name);
    }
}
