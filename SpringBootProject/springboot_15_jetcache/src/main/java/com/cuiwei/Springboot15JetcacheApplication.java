package com.cuiwei;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation  //使用注解进行配置缓存   启用缓存的主开关
public class Springboot15JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot15JetcacheApplication.class, args);
    }

}
