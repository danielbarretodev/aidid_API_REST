package com.aidid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aidid.entity.Collaborator;
import com.aidid.entity.Donation;


public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
	
	Optional<Collaborator> findByUsername(String userName);
}
