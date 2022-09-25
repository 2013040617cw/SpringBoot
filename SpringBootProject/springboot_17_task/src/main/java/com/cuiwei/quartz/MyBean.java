package com.cuiwei.quartz;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    @Scheduled(cron = "0/5 * * * * ?")
    public void perint(){
        System.out.println("小飞棍来咯...");
    }
}
