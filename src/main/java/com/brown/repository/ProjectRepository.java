package com.brown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brown.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
