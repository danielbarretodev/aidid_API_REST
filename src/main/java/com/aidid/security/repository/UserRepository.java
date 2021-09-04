package com.aidid.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aidid.security.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
	User findByUsername(String username);
}
