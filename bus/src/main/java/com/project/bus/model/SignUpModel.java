package com.project.bus.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class SignUpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String email;
    private String password;
    private String name;
    private String phn;
    @JsonManagedReference
    @OneToMany(mappedBy = "signUpModel", cascade = CascadeType.ALL)
    private List<Booking> booking;

}
