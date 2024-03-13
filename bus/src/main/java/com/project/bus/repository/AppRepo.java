package com.project.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bus.model.SignUpModel;

@Repository
public interface AppRepo extends JpaRepository<SignUpModel, Integer> {

}
