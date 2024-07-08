package com.pmf.rzk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmf.rzk.model.UsersAzd;

@Repository
public interface KorisnikRepo extends JpaRepository<UsersAzd, Integer>{
	Optional<UsersAzd> findByEmail(String email);
}
