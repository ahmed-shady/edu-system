package com.segmatek.scienceclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ScienceClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScienceClubApplication.class, args);
	}

}
