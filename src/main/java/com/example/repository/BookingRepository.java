package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Optional<Booking> findByBookingId(Integer bookingId); 
}
