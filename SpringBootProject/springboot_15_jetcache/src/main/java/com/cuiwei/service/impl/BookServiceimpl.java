package com.cuiwei.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.*;
import com.cuiwei.dao.BookDao;
import com.cuiwei.domain.Book;
import com.cuiwei.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceimpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    @Cached(name="book_",key="#id",expire = 3600,cacheType = CacheType.REMOTE)
    // @CacheRefresh(refresh = 5)  设置每几分钟执行一次查询
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name="book_",key="#book.id",value="#book")
    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name="book_",key = "#id")
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
