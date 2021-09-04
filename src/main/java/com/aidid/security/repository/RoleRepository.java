package com.aidid.security.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aidid.security.entity.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Optional<Role> findByName(String name);
}
