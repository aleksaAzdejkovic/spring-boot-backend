package com.pmf.rzk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmf.rzk.model.BetsAzd;
import com.pmf.rzk.model.UsersAzd;

@Repository
public interface BetRepo extends JpaRepository<BetsAzd, Integer> {
    List<BetsAzd> findByUsersAzd(UsersAzd usersAzd);
}
