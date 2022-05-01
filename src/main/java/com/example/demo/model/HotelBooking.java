package com.example.demo.model;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public  class HotelBooking {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min=1, max=10000, message="bookingId value should be min of 1 and maximum 10000")
	private int bookingId;
    
	@Range(min=1, max=10000, message="hotelId value should be min of 1 and maximum 10000")
	private int hotelId;

	@Range(min=1, max=10000, message="roomId value should be min of 1 and maximum 10000")
	  private int roomId;
	
	@Range(min=1, max=10000, message="userId value should be min of 1 and maximum 10000")
	  private int userId;
	  
	@NotNull
	  private Date startDate; 
	  
	@NotNull
	  private Date endDate;
	  
	  @Min(100)
	  @Max(10000)
	  private float cost;
	  
	  @NotBlank
	  @Size(min=2,message="PaymentStatus length should be minimum 2")
	  private String paymentStatus;
	  
	 

		/*
		 * public void setBookingId(int bookingId) { this.bookingId = bookingId; }
		 * 
		 * public int getBookingId() { return bookingId; }
		 */
}
/*
 * import java.sql.Date;
 * 
 * import javax.persistence.Entity; import javax.persistence.Id; import
 * javax.validation.constraints.NotBlank;
 * 
 * @Entity public class HotelBooking {
 * 
 * 
 * 
 * @Id private int bookingId;
 * 
 * @NotBlank private int hotelId;
 * 
 * @NotBlank private int roomId;
 * 
 * @NotBlank private int userId;
 * 
 * private Date startDate; private Date endDate; private int cost; private
 * String paymentStatus;
 * 
 * 
 * public int getBookingId() { return bookingId; } public void setBookingId(int
 * bookingId) { this.bookingId = bookingId; } public int getHotelId() { return
 * hotelId; } public void setHotelId(int hotelId) { hotelId = hotelId; } public
 * int getRoomId() { return roomId; } public void setRoomId(int roomId) { roomId
 * = roomId; } public int getUserId() { return userId; } public void
 * setUserId(int userId) { this.userId = userId; } public Date getStartDate() {
 * return startDate; } public void setStartDate(Date startDate) { this.startDate
 * = startDate; } public Date getEndDate() { return endDate; } public void
 * setEndDate(Date endDate) { this.endDate = endDate; } public int getCost() {
 * return cost; } public void setCost(int cost) { this.cost = cost; } public
 * String getPaymentStatus() { return paymentStatus; } public void
 * setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus;
 * } public HotelBooking(int bookingId, int hotelId, int roomId, int userId,
 * Date startDate, Date endDate, int cost, String paymentStatus) { super();
 * this.bookingId = bookingId; this.hotelId = hotelId; this.roomId = roomId;
 * this.userId = userId; this.startDate = startDate; this.endDate = endDate;
 * this.cost = cost; this.paymentStatus = paymentStatus; }
 * 
 * public HotelBooking() { super(); // TODO Auto-generated constructor stub }
 * 
 * @Override public String toString() { return "HotelBooking [bookingId=" +
 * bookingId + ", HotelId=" + hotelId + ", RoomId=" + roomId + ", userId=" +
 * userId + ", startDate=" + startDate + ", endDate=" + endDate + ", cost=" +
 * cost + ", paymentStatus=" + paymentStatus + "]"; }
 * 
 * 
 * }
 */