package com.aidid.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aidid.entity.Collaborator;
import com.aidid.entity.Organization;
import com.aidid.entity.SolidarityHistory;
import com.aidid.repository.CollaboratorRepository;
import com.aidid.repository.SolidarityHistoryRepository;
import com.aidid.security.entity.Role;
import com.aidid.security.repository.RoleRepository;
import com.aidid.service.CollaboratorService;


@Service
@Transactional
public class CollaboratorServiceImpl implements CollaboratorService{

	
	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	@Autowired
	private SolidarityHistoryRepository solidarityHistoryRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	
	@Override
	public Collaborator save(Collaborator collaborator) {
		// TODO Auto-generated method stub
		
		Collaborator collaboratorSave = collaboratorRepository.save(collaborator);
		SolidarityHistory sh = new SolidarityHistory();
		SolidarityHistory solidarityHistorySave = this.solidarityHistoryRepository.save(sh);
		solidarityHistorySave.setCollaboratorId(collaboratorSave.getId());
		solidarityHistorySave.setCollaboratorUserName(collaboratorSave.getUsername());
		collaborator.setSolidarityHistory(sh);
		collaborator.setPassword(bcryptEncoder.encode(collaborator.getPassword()));
			
					    
        return collaboratorSave; 
	}

	@Override
	public List<Collaborator> findAll() {
		// TODO Auto-generated method stub
		return collaboratorRepository.findAll();
	}

	@Override
	public Optional<Collaborator> findById(Long id) {
		// TODO Auto-generated method stub
		return collaboratorRepository.findById(id);
	}

	@Override
	public Optional<Collaborator> findByUsername(String userName) {
		// TODO Auto-generated method stub
		return collaboratorRepository.findByUsername(userName);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		collaboratorRepository.deleteById(id);
	}

}
