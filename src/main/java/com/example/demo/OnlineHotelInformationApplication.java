package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@EnableEurekaServer
public class OnlineHotelInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineHotelInformationApplication.class, args);

	}

}