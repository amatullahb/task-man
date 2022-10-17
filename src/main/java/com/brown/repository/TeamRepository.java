package com.brown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brown.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	
}
