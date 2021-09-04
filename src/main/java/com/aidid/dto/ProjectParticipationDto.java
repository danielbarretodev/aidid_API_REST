package com.aidid.dto;

import com.aidid.entity.Project;
import com.aidid.entity.ProjectParticipation;

import lombok.Data;


@Data
public class ProjectParticipationDto {
	
	private ProjectParticipation projectParticipation;
	private Project Project;
	private Long idSolidarityHistory;

}
