package com.cuiwei;

import com.alibaba.druid.pool.DruidDataSource;
import com.cuiwei.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;

@SpringBootApplication
public class Springboot09ConfigrationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource(){
        DruidDataSource ds  = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot09ConfigrationApplication.class, args);
        ServerConfig bean = run.getBean(ServerConfig.class);
        DruidDataSource bean1 = run.getBean(DruidDataSource.class);
        System.out.println(bean1);
        System.out.println(bean);
        System.out.println(bean1.getDriverClassName());

    }

}
