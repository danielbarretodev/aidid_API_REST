package com.aidid.service;

import java.util.List;
import java.util.Optional;

import com.aidid.entity.Collaborator;

public interface CollaboratorService {

	Collaborator save(Collaborator collaborator);

    List<Collaborator> findAll();
    
    Optional<Collaborator> findById(Long id);
    
    Optional<Collaborator> findByUsername(String userName);

    void delete(Long id);
	
}
