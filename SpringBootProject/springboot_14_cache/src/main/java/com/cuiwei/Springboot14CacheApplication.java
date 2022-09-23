package com.cuiwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启缓存
@EnableCaching
public class Springboot14CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot14CacheApplication.class, args);
	}

}
