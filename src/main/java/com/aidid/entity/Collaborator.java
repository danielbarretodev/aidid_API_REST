package com.aidid.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aidid.security.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Collaborator extends User {

	private String name;
	private String surname;
	private Integer phone;
	private String email;
	
	@OneToOne()
	private SolidarityHistory solidarityHistory;
	
}
