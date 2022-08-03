package com.cuiwei.dao.Impl;

import com.cuiwei.dao.BootDao;
import org.springframework.stereotype.Repository;


@Repository
public class BootDaoimpl implements BootDao {
    @Override
    public void save() {
        System.out.println("开始执行了");
    }
}
