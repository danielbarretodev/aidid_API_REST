package com.aidid.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.Data;

@Entity
@Data
@Table(name="donation")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float amount;
	private String description; 
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	private Long solidarityHistoryId;
	private Long organizationId;
	private String organizationUserName;

}
