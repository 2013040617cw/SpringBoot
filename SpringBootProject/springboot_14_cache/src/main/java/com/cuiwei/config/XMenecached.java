package com.cuiwei.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.swing.*;

@Configuration

public class XMenecached {
    @Autowired
    private XMemcachedProperties xMemcachedProperties;
    @Bean
    public MemcachedClient  getMemcachedClient() throws  Exception{

        //创建服务器
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(xMemcachedProperties.getServers());
        //创建客户端
        MemcachedClient memcachedClient = memcachedClientBuilder.build();
        return memcachedClient;

    }
}
