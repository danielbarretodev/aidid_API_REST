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
import org.springframework.web.bind.annotation.RestController;

import com.aidid.entity.Collaborator;
import com.aidid.security.entity.User;
import com.aidid.security.service.UserService;
import com.aidid.service.CollaboratorService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/collaborator")
public class CollaboratorController {

	@Autowired
	CollaboratorService collaboratorService;
	
	
	
	@GetMapping()
    public List<Collaborator> list() {
        return collaboratorService.findAll();
    }
    
    @GetMapping("/{id}")
    public Collaborator get(@PathVariable Long id) {   
        Collaborator customer = collaboratorService.findById(id).get();         
        return customer;   
    }  
   
    
    @PutMapping("/{id}")
    public ResponseEntity<Collaborator> put(@PathVariable String id, @RequestBody Collaborator input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Collaborator input) {
    	
        try {
    			return new ResponseEntity<Collaborator>(collaboratorService.save(input), HttpStatus.CREATED);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			return new ResponseEntity<Collaborator>(
    					HttpStatus.BAD_REQUEST);
    		}

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Collaborator> delete(@PathVariable Long id) {
    //no hace falta comprobar nada, intentamos la operacion y si salta una excepcion
    	//devolvemos un erro http
    	Optional<Collaborator> u =  collaboratorService.findById(id);
		
		 if(u.isPresent())
		 {
			  collaboratorService.delete(id);
			  return (ResponseEntity<Collaborator>) ResponseEntity.ok();
			   
		 }
		 
		 return (ResponseEntity<Collaborator>) ResponseEntity.badRequest();
    }
}
