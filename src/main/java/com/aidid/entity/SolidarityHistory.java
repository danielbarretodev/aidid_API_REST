package com.aidid.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Entity
@Data
@Table(name="solidarityHistory")
public class SolidarityHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany(targetEntity = Membership.class)   
	private List<Membership> memberships;
	
	@OneToMany(targetEntity = Donation.class)   
	private List<Donation> donations;
	
	@OneToMany(targetEntity = ProjectParticipation.class)   
	private List<ProjectParticipation> projectParticipations;
	
	private Long collaboratorId;
	
	private String collaboratorUserName;
	
}
