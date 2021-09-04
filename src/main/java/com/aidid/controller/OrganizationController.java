package com.aidid.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aidid.entity.Collaborator;
import com.aidid.entity.Organization;
import com.aidid.service.OrganizationService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/organization")
public class OrganizationController {

	
	@Autowired
	OrganizationService organizationService;
	
	@GetMapping()
    public List<Organization> list() {
        return organizationService.findAll();
    }
    
    @GetMapping("/{id}")
    public Organization get(@PathVariable long id) {   
        Organization customer = organizationService.findById(id).get();         
        return customer;   
    }  
   
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Organization input) {
        return null;
    }
    
   @PostMapping
    public ResponseEntity<Organization> post(@RequestBody Organization input) {       

	     try {
 			return new ResponseEntity<Organization>(organizationService.save(input), HttpStatus.CREATED);
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 			return new ResponseEntity<Organization>(
 					HttpStatus.BAD_REQUEST);
 		}

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }



}
