package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HotelBooking;
import com.example.demo.repository.HotelBookingRepo;

@Service
public class HotelBookingService {

	
	@Autowired
	HotelBookingRepo bookRepos;
	
	public HotelBooking addHotelBooking(HotelBooking bookObj) {
		return bookRepos.save(bookObj);
	}

	public List<HotelBooking> getAllHotelBooking() {
		return bookRepos.findAll();
	}
	public List<HotelBooking> updateHotelBooking(HotelBooking bookObj){
		 bookRepos.save(bookObj);
		 return getAllHotelBooking();
	}
	
	  public int deleteHotelBookingById(int id){ 
		  bookRepos.deleteById(id);
		  return id;
    }
	 
	
	public Optional<HotelBooking> fetchByBookingId(int id) {
		return bookRepos.findByBookingId(id);
	}
	
	public Optional<HotelBooking> findByCost(float cost) {
		Optional<HotelBooking> bo= bookRepos.findByCost(cost);
		return bo;
	}
	/*
	 * public List<HotelBooking> findListCost(float cost) { List<HotelBooking> bo=
	 * bookRepos.findCostBy(cost); return bo; }
	 */
}