package com.aidid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aidid.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	Optional<Organization> findByUsername(String userName);
}
