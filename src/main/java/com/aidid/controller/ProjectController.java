package com.aidid.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aidid.dto.ProjectDto;
import com.aidid.entity.Organization;
import com.aidid.entity.Project;
import com.aidid.service.OrganizationService;
import com.aidid.service.ProjectService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	OrganizationService organizationService;
	
	@GetMapping()
    public ResponseEntity<List<Project>> list() {
        return new ResponseEntity<>(projectService.findAll(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public Project get(@PathVariable long id) {   
        Project customer = projectService.findById(id).get();         
        return customer;   
    }  
   
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Project input) {
    	this.projectService.update(input);
    	return new ResponseEntity<>(input,HttpStatus.CREATED);
    }
    
   @PostMapping
   public ResponseEntity<?> post(@RequestBody Project input) {       
       
	   projectService.save(input);
	   
	   return new ResponseEntity<>(input,HttpStatus.CREATED);
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
    	try {
    		this.projectService.delete(Long.parseLong(id));
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch(Exception e)
    	{
    		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    	}
    }

}
