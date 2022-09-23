package com.cuiwei;
import com.cuiwei.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.List;
@SpringBootTest
class Springboot12MongodbApplicationTests {
     @Resource
    private MongoTemplate mongoTemplate;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(2);
        book.setName("崔巍最帅");
        book.setType("超人类");
        book.setDescription("我家住在翻斗乐园，我在翻斗幼儿园");
        mongoTemplate.save(book);
    }
    @Test
    void findAll(){
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println(all);
    }
}
