package com.aidid.service;

import java.util.List;
import java.util.Optional;

import com.aidid.dto.ProjectParticipationDto;
import com.aidid.entity.ProjectParticipation;

public interface ProjectParticipationService {

    List<ProjectParticipation> findAll();
    
    Optional<ProjectParticipation> findById(Long id);
    
    Optional<ProjectParticipation> findByProjectParticipation(String projectParticipation);

    void delete(Long id);

	ProjectParticipation save(ProjectParticipationDto projectParticipationDto);

	
	
}
