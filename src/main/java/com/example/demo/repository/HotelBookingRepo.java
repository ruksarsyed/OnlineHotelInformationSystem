package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HotelBooking;

@Repository
public interface HotelBookingRepo extends JpaRepository<HotelBooking, Integer> {

	public Optional<HotelBooking> findByBookingId(int id);

	@Query(value = "select e from HotelBooking e where e.cost = :cost")
	Optional<HotelBooking> findByCost(@Param("cost") float cost);
	// List<HotelBooking> findCostBy(@Param("cost") float cost);

}