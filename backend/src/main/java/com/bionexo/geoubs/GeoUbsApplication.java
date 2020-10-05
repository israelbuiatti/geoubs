package com.bionexo.geoubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GeoUbsApplication implements WebMvcConfigurer {
	
	public static void main(String[] args) {
		SpringApplication.run(GeoUbsApplication.class, args);
	}

}
