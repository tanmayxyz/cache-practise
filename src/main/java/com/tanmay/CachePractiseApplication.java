package com.tanmay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachePractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachePractiseApplication.class, args);
	}

}
