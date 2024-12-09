package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Booking;
import com.example.entity.Customer;
import com.example.repository.BookingRepository;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;
	
	public List<Customer> getAllCutomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}
	
	public void saveCustomer(Customer customer) {
	    if (customer.getBooking() != null) {
	        Optional<Booking> bookingOpt = bookingRepository.findByBookingId(customer.getBooking().getbookingId());
	        bookingOpt.ifPresent(customer::setBooking);
	    }
	    customerRepository.save(customer);
	}

	
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
	
	public List<String> getCustomerByBookingId(Integer id) {
		List<Customer> customers = customerRepository.findCustomersByBookingId(id);
		List<String> customerNames = new ArrayList<String>();
		if(customerNames != null) {
			customers.forEach(c -> customerNames.add(c.getName()));
		}
		return customerNames;
		
	}
}
