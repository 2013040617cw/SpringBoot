package com.itcuiwei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class BookController {

    @RestController
    @RequestMapping("/book")
    public class BookControler {

        @GetMapping
        public String getByID(){
            System.out.println("springboot is Running ... 4");
            return "springboot is Running .... 4";
        }
    }
}
