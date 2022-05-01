package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HotelBooking;
import com.example.demo.service.HotelBookingService;

@RestController
@RequestMapping("/HotelBooking")
public class HotelBookingController {

	@Autowired
	HotelBookingService service;
	
	@GetMapping("/booking")
	public String getBooking() {
		return "Booking";
	}

	@PostMapping("/addBooking")
	// @ResponseBody
	public ResponseEntity<String> addHotelBookingDetails(@Validated @RequestBody HotelBooking book) {
		Optional<HotelBooking> bookObj = service.fetchByBookingId(book.getBookingId());
		if (!bookObj.isPresent()) {
			HotelBooking bookResponse = service.addHotelBooking(book);
			return new ResponseEntity<String>(bookResponse.getBookingId() + "has been inserted successfully",
					HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Given id is already present");
		}
			}

	@GetMapping("/getAllBooking")
	public ResponseEntity<List<HotelBooking>> fetchAllHotelBooking() {
		List<HotelBooking> bookObj = service.getAllHotelBooking();
		return new ResponseEntity<List<HotelBooking>>(bookObj, HttpStatus.OK);
	}

	@GetMapping("/getBookingById")
	public ResponseEntity<HotelBooking> fetchBookingById(@RequestParam("id") int id) {
		Optional<HotelBooking> bookObj = service.fetchByBookingId(id);
		if (bookObj.isPresent()) {
			Optional<HotelBooking> book = service.fetchByBookingId(id);
			//service.updateHotelBooking(book);
			return new ResponseEntity<HotelBooking>(book.get(), HttpStatus.OK);
			//status = "Successfully Updated";
		} else {
			throw new ResourceNotFoundException("Given id it's not available in db..");
		}
		//return new ResponseEntity<HotelBooking>(book.get(), HttpStatus.OK);
	}
   
	
	@GetMapping("/getBookingByCost")
	public ResponseEntity<HotelBooking> fetchBookingByCost(@RequestParam("cost") float cost) {
		Optional<HotelBooking> bookObj = service.findByCost(cost);
		if (bookObj.isPresent()) {
			Optional<HotelBooking> book = service.findByCost(cost);
			//service.updateHotelBooking(book);
			return new ResponseEntity<HotelBooking>(book.get(), HttpStatus.OK);
			//status = "Successfully Updated";
		} else {
			throw new ResourceNotFoundException("Given cost it's not available in db..");
		}
		//return new ResponseEntity<HotelBooking>(book.get(), HttpStatus.OK);
	}
	
	
	@PutMapping("/updateBookingById")
	public ResponseEntity<String> updateBookingById(@RequestBody HotelBooking book) {
		String status = null;
		Optional<HotelBooking> bookObj = service.fetchByBookingId(book.getBookingId());

		if (bookObj.isPresent()) {
			service.updateHotelBooking(book);
			status = "Successfully Updated";
		} else {
			throw new ResourceNotFoundException("Given id it's not available in db..");
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@GetMapping("/deleteBookingById")
	public ResponseEntity<String> deleteBookingById(@RequestParam("id") int id){
		
		Optional<HotelBooking> bookObj = service.fetchByBookingId(id);
		if (bookObj.isPresent()) {
			/*
			 * service.updateHotelBooking(book); status = "Successfully Updated";
			 */
			int iid = service.deleteHotelBookingById(id);
			return new ResponseEntity<String>(iid + "has been deleted successfully",
					HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Given id it's not available in db..");
		}
		//return new ResponseEntity<String>(iid + "has been deleted successfully",
				//HttpStatus.OK);
	}

}