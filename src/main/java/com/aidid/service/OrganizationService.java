package com.aidid.service;

import java.util.List;
import java.util.Optional;

import com.aidid.entity.Collaborator;
import com.aidid.entity.Organization;

public interface OrganizationService {
	
	Organization save(Organization user);

    List<Organization> findAll();
    
    Optional<Organization> findById(Long id);
    
    Optional<Organization> findByName(String user);
    
    Optional<Organization> findByUsername(String userName);

    void delete(Long id);

}
