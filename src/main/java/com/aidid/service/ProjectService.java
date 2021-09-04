package com.aidid.service;

import java.util.List;
import java.util.Optional;

import com.aidid.dto.ProjectDto;
import com.aidid.entity.Project;

public interface ProjectService {
	

    List<Project> findAll();
    
    Optional<Project> findById(Long id);
    
    Optional<Project> findByProject(String project);

    void delete(Long id);
	
	Project update(Project project);

	Project save(Project project);


}
