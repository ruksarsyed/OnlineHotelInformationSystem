package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*import java.time.Date;
import java.util.Date;*/
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.HotelBooking;
import com.example.demo.repository.HotelBookingRepo;
import com.example.demo.service.HotelBookingService;

@SpringBootTest
class OnlineHotelManagementApplicationTests {

	@MockBean
	private HotelBookingRepo bookingrepo;

	@Autowired
	private HotelBookingService service;

	/*
	 * @Test void contextLoads() {
	 * 
	 * }
	 */
	// fetchAllBooking

	@Test
	public void getAllBooking() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = format.parse("05-06-2010");
		Date endDate = format.parse("02-07-2010");
		when(bookingrepo.findAll())
				.thenReturn(Stream.of(new HotelBooking(123, 234, 456, 678, startDate, endDate, 300.8f, "Booked"))
						.collect(Collectors.toList()));
		assertEquals(1, service.getAllHotelBooking().size());
	}

	// fetchBookingById //@Test

	@Test
	public void getBookingById() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = format.parse("05-06-2010");
		Date endDate = format.parse("02-07-2010");
		int id = 123;
		HotelBooking book = new HotelBooking(123, 234, 456, 678, startDate, endDate, 300.8f, "Booked");
		when(bookingrepo.findByBookingId(id)).thenReturn(Optional.of(book));
		assertEquals(book.toString(), service.fetchByBookingId(id).get().toString());
	}

	// SaveBooking

	@Test
	public void saveBooking() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = format.parse("05-06-2010");
		Date endDate = format.parse("02-07-2010");
		HotelBooking book = new HotelBooking(123, 234, 456, 678, startDate, endDate, 300.8f, "Booked");
		when(bookingrepo.save(book)).thenReturn(book);
		assertEquals(book.toString(), service.addHotelBooking(book).toString());
	}

	// fetchBookingByCost

	/*
	 * @Test public void getBookingByCost() { float cost=300.8f;
	 * when(bookingrepo.findByCost(cost)).thenReturn(Stream.of(new
	 * HotelBooking(123,234,456, 678, startDate, endDate , 300.8f,
	 * "Booked")).collect(Collectors.toList()));
	 * assertEquals(1,service.findByCost(cost).size()); }
	 * 
	 */

	// updateBookingById

	/*
	 * @Test public void updateBookingById() { HotelBooking book=new
	 * HotelBooking(123, 234, 456, 678,startDate,endDate, 300.8f, "Booked");
	 * when(bookingrepo.findByBookingId(book.getBookingId()).thenReturn(Stream.of(
	 * service.updateHotelBooking(book))).collect(Collectors.toList()));
	 * assertEquals(book,service.fetchByBookingId(book.getBookingId())); }
	 */

	// deleteByBookingId

	@Test
	public void deleteBookingById() {
		int id = 123;
		HotelBooking book = bookingrepo.getById(id);
		bookingrepo.delete(book);
		HotelBooking book2 = null;
		Optional<HotelBooking> b = bookingrepo.findByBookingId(id);
		if (b.isPresent()) {
			book2 = b.get();
		}
		Assertions.assertNull(book2);

	}

}