package com.aidid.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidid.dto.ProjectParticipationDto;
import com.aidid.entity.Collaborator;
import com.aidid.entity.Organization;
import com.aidid.entity.Project;
import com.aidid.entity.ProjectParticipation;
import com.aidid.entity.SolidarityHistory;
import com.aidid.repository.CollaboratorRepository;
import com.aidid.repository.OrganizationRepository;
import com.aidid.repository.ProjectParticipationRepository;
import com.aidid.repository.ProjectRepository;
import com.aidid.repository.SolidarityHistoryRepository;
import com.aidid.service.ProjectParticipationService;

@Service
@Transactional
public class ProjectParticipationServiceImpl implements ProjectParticipationService{
	
	@Autowired
	ProjectParticipationRepository projectParticipationRepository;
	
	@Autowired
	SolidarityHistoryRepository solidarityHistoryRepository;
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public ProjectParticipation save(ProjectParticipationDto projectParticipationDto) {
		// TODO Auto-generated method stub

		List<ProjectParticipation> lpp = null;	
		
		ProjectParticipation projectParticipationSave = this.projectParticipationRepository.save(projectParticipationDto.getProjectParticipation());
		
		
		Optional<SolidarityHistory> os = solidarityHistoryRepository.findById(projectParticipationDto.getIdSolidarityHistory());
		if(os.isPresent())
		{
			lpp = os.get().getProjectParticipations();
			lpp.add(projectParticipationSave);
			os.get().setProjectParticipations(lpp);
			this.solidarityHistoryRepository.save(os.get());
			projectParticipationSave.setSolidarityHistoryId(os.get().getId());
		}
		
		Optional<Project> optPr = this.projectRepository.findById(projectParticipationDto.getProject().getId());
		if(optPr.isPresent())
		{
			lpp = optPr.get().getProjectParticipations();
			lpp.add(projectParticipationSave);
			optPr.get().setProjectParticipations(lpp);
			this.projectRepository.save(optPr.get());
			projectParticipationSave.setProjectId(optPr.get().getId());
		}
		
		this.projectParticipationRepository.save(projectParticipationSave);
		
		return projectParticipationSave;
		
	}

	@Override
	public List<ProjectParticipation> findAll() {
		// TODO Auto-generated method stub
		return projectParticipationRepository.findAll();
	}

	@Override
	public Optional<ProjectParticipation> findById(Long id) {
		// TODO Auto-generated method stub
		return projectParticipationRepository.findById(id);
	}

	@Override
	public Optional<ProjectParticipation> findByProjectParticipation(String projectParticipation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long ppId) {
		// TODO Auto-generated method stub
		List<ProjectParticipation> lpp = null;
		Optional<ProjectParticipation> optpp = projectParticipationRepository.findById(ppId);
		Optional<SolidarityHistory> optSol = null;
		if(optpp.isPresent())
		{
			optSol = this.solidarityHistoryRepository.findById(optpp.get().getSolidarityHistoryId());
		}
		
		if(optSol.isPresent())
		{
			lpp = optSol.get().getProjectParticipations();
			lpp.removeIf(pp -> pp.getId().equals(ppId));
			optSol.get().setProjectParticipations(lpp);
			this.solidarityHistoryRepository.save(optSol.get());
		}
		
		Optional<Project> optPr = this.projectRepository.findById(optpp.get().getProjectId());
		if(optPr.isPresent())
		{
			lpp = optPr.get().getProjectParticipations();
			lpp.removeIf(pp -> pp.getId().equals(ppId));
			optPr.get().setProjectParticipations(lpp);
			this.projectRepository.save(optPr.get());
		}
		
		projectParticipationRepository.deleteById(ppId);
	}

}
