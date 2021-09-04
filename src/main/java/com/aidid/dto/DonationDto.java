package com.aidid.dto;

import com.aidid.entity.Donation;
import com.aidid.entity.Membership;

import lombok.Data;

@Data
public class DonationDto {
	
	private Donation donation;
	private Long idSolidarityHistory;
	private Long idOrganization;
}
