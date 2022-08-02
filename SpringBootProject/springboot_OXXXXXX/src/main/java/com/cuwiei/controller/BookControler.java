package com.cuwiei.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/book2")
public class BookControler {

    @GetMapping
    public String getByID(){
        System.out.println("springboot is Running...2");
        return "springboot is Running...2";
    }
}


