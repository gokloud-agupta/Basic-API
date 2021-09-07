package com.gokloud.tdd.dao;

import com.gokloud.tdd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
