package com.demo.backend.sbmssf.repository;

import com.demo.backend.sbmssf.model.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<MyUsers, Long> {
    public Optional<MyUsers> findByUserId(Long uId);
}
