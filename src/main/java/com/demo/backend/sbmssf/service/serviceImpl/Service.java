package com.demo.backend.sbmssf.service.serviceImpl;

import com.demo.backend.sbmssf.model.MyUsers;
import com.demo.backend.sbmssf.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;


    public Optional<?> getUserById(Long id) {
        return repository.findByUserId(id);
    }

    public Object getAllUsers() {
        return repository.findAll();
    }

    public Object saveUserToDB(MyUsers user) throws InterruptedException {
        repository.save(user);
        Thread.sleep(3000);
        Optional<MyUsers> fromRepoObj =  repository.findByUserId(user.getUserId());

        return fromRepoObj.isPresent() && fromRepoObj.get().getUserId() ==  user.getUserId() ? true: false;

    }

}
