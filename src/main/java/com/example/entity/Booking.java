package com.example.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_08122024")
public class Booking {

	@Id
	@GeneratedValue
	private Integer bookingId;
	
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	List<Customer> customers;
	
	@Column(name = "booking_pickup")
	private String pickupLocation;
	
	@Column(name = "booking_drop")
	private String DropLocation;
	
	@Column(name = "booking_time")
	private LocalDateTime bookingTime;

	public int getbookingId() {
		return bookingId;
	}

	public void setbookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return DropLocation;
	}

	public void setDropLocation(String dropLocation) {
		DropLocation = dropLocation;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}
}
