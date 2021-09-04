package com.aidid.security.controller;

import com.aidid.security.config.TokenProvider;
import com.aidid.security.dto.AuthToken;
import com.aidid.security.dto.LoginUser;
import com.aidid.security.dto.UserDto;
import com.aidid.security.entity.User;
import com.aidid.security.service.UserService;

import static com.aidid.security.entity.Constants.TOKEN_PREFIX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser) throws AuthenticationException {

    
	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginUser.getUsername(),
	                        loginUser.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = jwtTokenUtil.generateToken(authentication);
	        User user = userService.findOne(loginUser.getUsername());
	        
	        return ResponseEntity.ok(new AuthToken(token,user));
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public String prueba() {
    	return "prueba";
    }

}
