package com.devfabiosimones.gntech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GntechApplication {

	public static void main(String[] args) {
		SpringApplication.run(GntechApplication.class, args);
	}

}
