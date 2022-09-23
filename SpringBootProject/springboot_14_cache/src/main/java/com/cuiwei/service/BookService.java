package com.cuiwei.service;

import com.cuiwei.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    public boolean save(Book book);
    public Book getById(Integer id);
    public boolean update(Book book);
    public boolean delete(Integer id);
    public List<Book> getAll();
}
