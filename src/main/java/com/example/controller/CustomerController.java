package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Customer;
import com.example.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	private List<Customer> getAllCustomer(){
		return customerService.getAllCutomers();
	}
	
	@PostMapping("/customer")
	private int saveCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer.getId();
	}
	
	@DeleteMapping("/customer/{id}")
	private void deleteCustomer(@PathVariable("id") int id) {
		customerService.delete(id);
	}
	
	@GetMapping("/customer/booking/{id}")
	private List<String> getCustomerByBookingId(@PathVariable("id") Integer id) {
		return this.customerService.getCustomerByBookingId(id);
	}
}
