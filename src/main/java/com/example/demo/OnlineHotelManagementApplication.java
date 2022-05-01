package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.HotelBooking;

@SpringBootApplication

public class OnlineHotelManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineHotelManagementApplication.class, args);

		HotelBooking hotel = new HotelBooking();
		hotel.setBookingId(12);
		// hotel.s
		System.out.println(hotel.getBookingId());
	}

}