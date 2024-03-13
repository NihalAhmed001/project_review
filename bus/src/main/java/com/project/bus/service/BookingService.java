package com.project.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bus.model.Booking;
import com.project.bus.repository.BookingRepo;

@Service
public class BookingService {
    @Autowired
    public BookingRepo bookingRepo;

    public Booking post(Booking entity) {
        bookingRepo.save(entity);
        return entity;
    }

}
