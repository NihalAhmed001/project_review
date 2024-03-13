package com.project.bus.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    private int customerId;
    private int busId;
    private String busName;
    private int ticketId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sp_id")
    private SignUpModel signUpModel;
}
