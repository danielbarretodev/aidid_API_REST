package com.aidid.security.service;

import com.aidid.security.dto.UserDto;
import com.aidid.security.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
	User save(User user) throws Exception;
}
