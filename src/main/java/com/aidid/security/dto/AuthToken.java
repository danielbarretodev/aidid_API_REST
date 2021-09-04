package com.aidid.security.dto;

import com.aidid.security.entity.User;

import lombok.Data;

@Data
public class AuthToken {

	   private String token;
	    private User user;
	    
	    public AuthToken(String token, User user) {
	    	this.token = token;
	    	this.user= user;
	    }
}
