package com.project.bus.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.bus.model.SignUpModel;
import com.project.bus.service.AppService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class AppContoller {
    @Autowired
    public AppService appService;

    @PostMapping("/post")
    public SignUpModel postMethodName(@RequestBody SignUpModel entity) {

        appService.signUpPost(entity);
        return entity;
    }

    @GetMapping("/getAll")
    public List<SignUpModel> getALL() {
        return appService.signInGet()
    }

    @GetMapping("/getOne/{id}")
    public SignUpModel getone(@PathVariable int id) {
        return appService.signInGetOne(id);
    }

    @PutMapping("update/{id}")
    public SignUpModel putMethodName(@PathVariable int id, @RequestBody SignUpModel entity) {

        appService.update(id, entity);
        return entity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SignUpModel> delete(@PathVariable("id") int id) {
        if (appService.deleteSignUpModel(id) == true) {
            return new ResponseEntity<SignUpModel>(HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getOne/{offset}/{pageSize}/{field}")
    public Page<SignUpModel> findAllSortedBy(@PathVariable int offset, @PathVariable int pageSize,
            @PathVariable String field) {
        return appService.findByOffset(offset, pageSize, field);
    }

    @GetMapping("/sort/{field}")
    public List<SignUpModel> getMethodName(@PathVariable("field") String field) {

        return appService.getPageSortList(field);
    }

}
