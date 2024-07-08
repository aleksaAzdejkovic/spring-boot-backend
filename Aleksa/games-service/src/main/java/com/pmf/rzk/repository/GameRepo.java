package com.pmf.rzk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmf.rzk.model.GamesAzd;

public interface GameRepo extends JpaRepository<GamesAzd, Integer>{

}
