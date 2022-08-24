package com.cuiwei.service.impl;

import com.cuiwei.dao.BookDao;
import com.cuiwei.domain.Book;
import com.cuiwei.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean save(Book book) {
       return bookDao.insert(book)>0;
    }
}
