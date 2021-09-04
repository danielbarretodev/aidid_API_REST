package com.aidid.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aidid.entity.Organization;
import com.aidid.entity.SolidarityHistory;
import com.aidid.repository.OrganizationRepository;
import com.aidid.security.entity.Role;
import com.aidid.security.repository.RoleRepository;
import com.aidid.service.OrganizationService;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

		
	@Override
	public Organization save(Organization organization) {
		// TODO Auto-generated method stub
		Set<Role> roles = new HashSet<>();
		
		organization.setPassword(bcryptEncoder.encode(organization.getPassword()));
			
					    
        return organizationRepository.save(organization);

		
		
	}

	@Override
	public List<Organization> findAll() {
		// TODO Auto-generated method stub
		return organizationRepository.findAll();
	}

	@Override
	public Optional<Organization> findById(Long id) {
		// TODO Auto-generated method stub
		return organizationRepository.findById(id);
	}

	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		organizationRepository.deleteById(id);
	}

	

	@Override
	public Optional<Organization> findByName(String organization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Organization> findByUsername(String userName) {
		// TODO Auto-generated method stub
		return this.organizationRepository.findByUsername(userName);
	}

}
