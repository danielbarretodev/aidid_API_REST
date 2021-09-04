package com.aidid.dto;

import com.aidid.entity.Collaborator;
import com.aidid.entity.Membership;
import com.aidid.entity.Organization;

import lombok.Data;

@Data
public class MembershipDto {
	
	private Membership membership;
	private Long idSolidarityHistory;
	private Long idOrganization;

}
