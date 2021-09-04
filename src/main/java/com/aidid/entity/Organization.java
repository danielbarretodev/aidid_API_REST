package com.aidid.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aidid.security.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Entity
@Data
public class Organization extends User {
	
	
	private String name;
	
	private String country;
	
	private String activityType;
	
	@OneToMany(targetEntity = Project.class)   
	private List<Project> projects;
	
	
	@OneToMany(targetEntity = Membership.class)   
	private List<Membership> memberships;

	@OneToMany(targetEntity = Donation.class)   
	private List<Donation> donations;

}