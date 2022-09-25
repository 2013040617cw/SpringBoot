package com.cuiwei.config;

import com.cuiwei.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    //定义工作明细   绑定具体的工作
    //storeDurably这个东西是做持久化的，如果你没有运行这个工作是否进行持久化，否则就会被干掉
    public JobDetail printJobDetail(){
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    //定义触发器   绑定对应的工作明细
    public Trigger printJobTrigger(){
        //定义工作运行的时间，意思是每2秒运行一次
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
        //定义绑定哪个工作明细并且绑定其工作周期
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(scheduleBuilder).build();
    }

}
