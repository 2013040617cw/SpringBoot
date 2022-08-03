package com.cuiwei.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuiwei.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {

}

