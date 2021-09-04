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

import com.aidid.entity.SolidarityHistory;
import com.aidid.service.SolidarityHistoryService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/solidarityHistory")
public class SolidarityHistoryController {

	@Autowired
	SolidarityHistoryService solidarityHistoryService;
	
	@GetMapping()
    public List<SolidarityHistory> list() {
        return solidarityHistoryService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {   
        SolidarityHistory sh = solidarityHistoryService.findById(id).get();         
        return  ResponseEntity.ok(sh);   
    }  
   
    @PostMapping
    public ResponseEntity<?> post(@RequestBody SolidarityHistory input) {       
        SolidarityHistory save = solidarityHistoryService.save(input);
        return ResponseEntity.ok(save);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody SolidarityHistory input) {
        SolidarityHistory sh = solidarityHistoryService.findById(id).get();   
        solidarityHistoryService.save(sh);
        return  ResponseEntity.ok(sh);   
    }
    
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        solidarityHistoryService.delete(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

	
}
