package com.aidid.security.dto;

import java.util.HashSet;
import java.util.Set;

import com.aidid.entity.Organization;
import com.aidid.security.entity.Role;
import com.aidid.security.entity.RoleEnum;
import com.aidid.security.entity.User;
import com.aidid.security.entity.UserTypeEnum;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
    private String username;
    private String password;
    private String name;
    private Set<RoleEnum> roles;
    private UserTypeEnum type;
    
    public static UserDto parse(User user)
    {
    	UserDto userDto = new UserDto();
    	userDto.setId(user.getId());
    	userDto.setUsername(user.getUsername());
    	userDto.setPassword(user.getPassword());
    	//userDto.setName(user.getName());
    //	Set<RoleEnum> roles = new HashSet<>();
    	/*
    	for(Role role: user.getRoles())
    	{
    		roles.add(RoleEnum.valueOf(role.getName()));
    	}
    	*/
    //	userDto.setRoles(roles);
    	if (user instanceof Organization) {
			userDto.setType(UserTypeEnum.ORGANIZATION);
		} else userDto.setType(UserTypeEnum.COLLABORATOR);
    	return userDto;
    }

}
