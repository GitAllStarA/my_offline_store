package com.demo.backend.sbmssf.controller;

import com.demo.backend.sbmssf.model.MyUsers;
import com.demo.backend.sbmssf.service.serviceImpl.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    Service userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        Optional<?> data =  userService.getUserById(id);
        if (data.isPresent()) {
            return ResponseEntity.ok(data.get());
        }
        else {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody MyUsers user) throws InterruptedException {
        Optional<Boolean> data = null;
        try {
            data = (Optional<Boolean>) userService.saveUserToDB(user);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (data.get()){
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

}
