package com.project.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bus.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
