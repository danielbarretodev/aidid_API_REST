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

import com.aidid.dto.DonationDto;
import com.aidid.entity.Donation;
import com.aidid.service.DonationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/donation")
public class DonationController {

	@Autowired
	DonationService donationService;
	
	
	
	@GetMapping()
    public List<Donation> list() {
        return donationService.findAll();
    }
    
    @GetMapping("/{id}")
    public Donation get(@PathVariable long id) {   
        Donation customer = donationService.findById(id).get();         
        return customer;   
    }  
   
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Donation input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody DonationDto input) {       
        Donation save = donationService.save(input);
        return ResponseEntity.ok(save);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
    	try {
    		this.donationService.delete(Long.parseLong(id));
    	    return new ResponseEntity<>(HttpStatus.OK);
    	} catch(Exception e)
    	{
    		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    	}
    
   }

}
