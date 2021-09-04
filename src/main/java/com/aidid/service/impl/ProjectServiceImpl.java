package com.aidid.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidid.dto.ProjectDto;
import com.aidid.entity.Organization;
import com.aidid.entity.Project;
import com.aidid.repository.OrganizationRepository;
import com.aidid.repository.ProjectParticipationRepository;
import com.aidid.repository.ProjectRepository;
import com.aidid.service.ProjectService;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	ProjectParticipationRepository projectParticipationRepository;
	
	@Override
	public Project save(Project project) {
		// TODO Auto-generated method stub
		List<Project> lp = null;
		
		
		Project projectSave = projectRepository.save(project);
	
		Optional<Organization> optOrganization = this.organizationRepository.findById(project.getOrganizationId());
		if(optOrganization.isPresent())
		{
			lp = optOrganization.get().getProjects();
			lp.add(projectSave);
			optOrganization.get().setProjects(lp);
			this.organizationRepository.save(optOrganization.get());
		}
	
		return this.projectRepository.save(projectSave);
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return  projectRepository.findAll();
	}

	@Override
	public Optional<Project> findById(Long id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id);
	}

	@Override
	public Optional<Project> findByProject(String project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long projectId) {
		// TODO Auto-generated method stub
		List<Project> lp = null;
		Optional<Project> optPr = this.projectRepository.findById(projectId);
		Optional<Organization> optOrganization = null;
		if(optPr.isPresent())
		{
			optOrganization = this.organizationRepository.findById(optPr.get().getOrganizationId());
		}
		
		if(optOrganization.isPresent())
		{
			lp = optOrganization.get().getProjects();
			lp.removeIf(p -> p.getId().equals(projectId));
			optOrganization.get().setProjects(lp);
			this.organizationRepository.save(optOrganization.get());
		}
		
		
		
		projectRepository.deleteById(projectId);
	}

	@Override
	public Project update(Project project) {
		// TODO Auto-generated method stub
		return this.projectRepository.save(project);
	}

}
