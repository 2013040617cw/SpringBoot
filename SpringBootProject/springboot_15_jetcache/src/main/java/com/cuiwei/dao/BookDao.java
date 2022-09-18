package com.cuiwei.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuiwei.doamin.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {
    }

