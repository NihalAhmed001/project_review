package com.project.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bus.model.Booking;
import com.project.bus.service.BookingService;

@RestController
public class BookingController {
    @Autowired
    public BookingService bookingService;

    @PostMapping("/post2")
    public Booking postMethodName(@RequestBody Booking entity) {

        bookingService.post(entity);
        return entity;
    }
}
