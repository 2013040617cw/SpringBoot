package com.cuiwei;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
class Springboot11RedisApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void sete() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age",14);

    }
    @Test
    void get(){
        ValueOperations opss = redisTemplate.opsForValue();
        Object age = opss.get("age");
        System.out.println(age);

    }
    @Test
    void Hset(){
        HashOperations ops= redisTemplate.opsForHash();
        ops.put("info","a","aa");

    }
    @Test
    void Hget(){
        HashOperations ops= redisTemplate.opsForHash();
        Object o = ops.get("info", "a");
        System.out.println(o);

    }

}
