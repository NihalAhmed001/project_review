package com.project.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.bus.model.SignUpModel;
import com.project.bus.repository.AppRepo;

@Service
public class AppService {

    @Autowired
    AppRepo appRepo;

    public SignUpModel signUpPost(SignUpModel entity) {
        appRepo.save(entity);
        return entity;
    }

    public List<SignUpModel> signInGet() {
        return appRepo.findAll();

    }

    public SignUpModel signInGetOne(int id) {
        return appRepo.findById(id).orElse(null);

    }

    public SignUpModel update(int id, SignUpModel entity) {
        entity.setId(id);
        appRepo.save(entity);
        return entity;

    }

    public boolean deleteSignUpModel(int id) {
        if (this.getSignUpModelById(id) == null) {
            return false;
        }
        appRepo.deleteById(id);
        return true;
    }

    private Object getSignUpModelById(int id) {
        return appRepo.findById(id).orElse(null);
    }

    public Page<SignUpModel> findByOffset(int offset, int pageSize, String field) {
        Sort sort = Sort.by(field);
        Pageable pg = PageRequest.of(offset, pageSize, sort);
        return appRepo.findAll(pg);
    }

    public List<SignUpModel> getPageSortList(String field) {

        return appRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }
}
