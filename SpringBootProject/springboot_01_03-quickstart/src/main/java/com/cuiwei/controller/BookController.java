package com.cuiwei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book3")
public class BookController {

    @GetMapping
    public String getByID(){
        System.out.println("Springboot is Running3");
        return "SpringBooot is Runnng ... 3";
    }
}
