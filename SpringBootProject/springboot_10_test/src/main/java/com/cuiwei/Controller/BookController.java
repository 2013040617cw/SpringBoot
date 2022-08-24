package com.cuiwei.Controller;

import com.cuiwei.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
//    @GetMapping
//    public String getById(){
//        System.out.println("崔巍真的帅。。。。");
//        return "springboot";
//    }

    @GetMapping
    public Book getById(){
        System.out.println("崔巍真的帅。。。。");
       Book book = new Book();
       book.setId(1);
       book.setName("崔巍");
       book.setType("帅哥");
       book.setDescription("他是中北大学第一帅比");
       return book;
    }
}
