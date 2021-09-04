package com.aidid.security.controller;

import com.aidid.security.dto.UserDto;
import com.aidid.security.entity.User;
import com.aidid.security.service.UserService;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public ResponseEntity<List<User>> list(){
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public User get(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }


    @PostMapping
    public ResponseEntity<?> post(@RequestBody User user){
        try {
			return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Uno de los roles introducidos no es correcto.",
					HttpStatus.BAD_REQUEST);
		}
		
    }
}

