package com.cuwiei.controller;


import com.cuwiei.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/book")
public class BookControler {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Environment env;

    //读取yml文件中的单一数据
    @Value("${country}")
    private  String country;

    //获取对象中的一个属性值
    @Value("${user.name}")
    private  String name1;

    //获取数组中的值
    @Value("${likes[1]}")
    private  String likes1;
    @GetMapping
    public String getByID(){
        System.out.println("springboot is Running...");
        System.out.println("country:" + country);
        System.out.println("name1:" + name1);
        System.out.println("likes1:" + likes1);

        System.out.println("-----------");
        System.out.println(env.getProperty("server.port"));
        System.out.println("-----------");
        System.out.println(dataSource);
        return "springboot is Running...";
    }


}


