package com.aidid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aidid.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
