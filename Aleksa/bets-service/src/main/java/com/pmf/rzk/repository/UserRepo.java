package com.pmf.rzk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmf.rzk.model.UsersAzd;

@Repository
public interface UserRepo extends JpaRepository<UsersAzd, Integer> {
}