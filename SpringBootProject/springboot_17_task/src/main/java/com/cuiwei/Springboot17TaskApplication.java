package com.cuiwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时任务的功能
@EnableScheduling
public class Springboot17TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot17TaskApplication.class, args);
    }

}
