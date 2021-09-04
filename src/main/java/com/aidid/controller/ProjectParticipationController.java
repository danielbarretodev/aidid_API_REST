package com.aidid.controller;

import java.util.List;

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

import com.aidid.dto.ProjectParticipationDto;
import com.aidid.entity.ProjectParticipation;
import com.aidid.service.ProjectParticipationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/projectParticipation")
public class ProjectParticipationController {

	@Autowired
	ProjectParticipationService projectParticipationService;
	
	@GetMapping()
    public List<ProjectParticipation> list() {
        return projectParticipationService.findAll();
    }
    
    @GetMapping("/{id}")
    public ProjectParticipation get(@PathVariable long id) {   
        ProjectParticipation customer = projectParticipationService.findById(id).get();         
        return customer;   
    }  
   
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody ProjectParticipation input) {
        return null;
    }
    
   @PostMapping
    public ResponseEntity<?> post(@RequestBody ProjectParticipationDto input) {       
        ProjectParticipation save = projectParticipationService.save(input);
        return ResponseEntity.ok(save);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
    	try {
    		this.projectParticipationService.delete(Long.parseLong(id));
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch(Exception e)
    	{
    		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    	}
    }

}
