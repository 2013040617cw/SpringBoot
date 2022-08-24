package com.cuiwei;

import com.cuiwei.domain.Book;
import com.cuiwei.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
public class DaoTest {
    @Autowired
    private BookService bookService;
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("springboot2");
        book.setType("springboot2");
        book.setDescription("springboot2");
        bookService.save(book);
    }
}
