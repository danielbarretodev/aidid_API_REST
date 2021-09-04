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

import com.aidid.dto.MembershipDto;
import com.aidid.entity.Membership;
import com.aidid.service.MembershipService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/membership")
public class MembershipController {

	@Autowired
	MembershipService membershipService;
	
	@GetMapping()
    public List<Membership> list() {
        return membershipService.findAll();
    }
    
    @GetMapping("/{id}")
    public Membership get(@PathVariable long id) {   
        Membership customer = membershipService.findById(id).get();         
        return customer;   
    }  
   
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Membership input) {
        return null;
    }
    
   @PostMapping
    public ResponseEntity<?> post(@RequestBody MembershipDto input) {   
	   
        Membership save = membershipService.save(input);
        return ResponseEntity.ok(save);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        membershipService.delete(Long.parseLong(id));
        
        return new ResponseEntity<Membership>(HttpStatus.ACCEPTED);
    }

	
	
}
