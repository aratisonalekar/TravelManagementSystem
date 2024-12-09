package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Integer> {

	@Query("SELECT c FROM Customer c WHERE c.booking.id = :bookingId")
	List<Customer> findCustomersByBookingId(@Param("bookingId") Integer bookingId);
}
