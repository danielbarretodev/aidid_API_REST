package com.aidid.dto;

import com.aidid.entity.Project;

import lombok.Data;

@Data
public class ProjectDto {
	
	private Project project;
	private Long organizationId;

}
