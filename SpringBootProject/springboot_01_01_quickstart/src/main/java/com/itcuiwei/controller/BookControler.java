package com.itcuiwei.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/book")
public class BookControler {

    @GetMapping
    public String getByID(){
        System.out.println("Hello,Spring boot");
        return "Hello,Spring boot";
    }
}


