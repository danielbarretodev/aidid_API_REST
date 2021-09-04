package com.aidid.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidid.dto.MembershipDto;
import com.aidid.entity.Collaborator;
import com.aidid.entity.Membership;
import com.aidid.entity.Organization;
import com.aidid.entity.SolidarityHistory;
import com.aidid.repository.CollaboratorRepository;
import com.aidid.repository.MembershipRepository;
import com.aidid.repository.OrganizationRepository;
import com.aidid.repository.SolidarityHistoryRepository;
import com.aidid.service.MembershipService;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	MembershipRepository membershipRepository;
	
	@Autowired
	SolidarityHistoryRepository solidarityHistoryRepository;
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Override
	public Membership save(MembershipDto membershipDto) {
		// TODO Auto-generated method stub
	
		List<Membership> lm = null;
		Optional<SolidarityHistory> os = solidarityHistoryRepository.findById(membershipDto.getIdSolidarityHistory());
		Membership membershipSave = this.membershipRepository.save(membershipDto.getMembership());
		
		if(os.isPresent())
		{
			lm = os.get().getMemberships();
			lm.add(membershipSave);
			 os.get().setMemberships(lm);
			 this.solidarityHistoryRepository.save(os.get());
			 membershipSave.setSolidarityHistoryId(os.get().getId());
		}
		
		
		
		Optional<Organization> optOrg = organizationRepository.findById(membershipDto.getIdOrganization());
		if(optOrg.isPresent())
		{
			lm = optOrg.get().getMemberships();
			lm.add(membershipSave);
			optOrg.get().setMemberships(lm);
			this.organizationRepository.save(optOrg.get());
			membershipSave.setOrganizationId(optOrg.get().getId());
			membershipSave.setOrganizationUserName(optOrg.get().getUsername());
		}
		
		this.membershipRepository.save(membershipSave);
		
		return membershipSave; 
	}

	@Override
	public List<Membership> findAll() {
		// TODO Auto-generated method stub
		return membershipRepository.findAll();
	}

	@Override
	public Optional<Membership> findById(Long id) {
		// TODO Auto-generated method stub
		return membershipRepository.findById(id);
	}

	@Override
	public Optional<Membership> findByMembership(String membership) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long membershipId) {
		// TODO Auto-generated method stub
		List<Membership> ml = null;
		Membership membership = this.membershipRepository.getOne(membershipId);
		Optional<SolidarityHistory> optSol = this.solidarityHistoryRepository.findById(membership.getSolidarityHistoryId());
		
		if(optSol.isPresent())
		{
			ml = optSol.get().getMemberships();
			ml.removeIf(m -> m.getId().equals(membershipId));
			optSol.get().setMemberships(ml);
			this.solidarityHistoryRepository.save(optSol.get());
		}
		
		
		Optional<Organization> optOrg = organizationRepository.findById(membership.getOrganizationId());
		if(optOrg.isPresent())
		{
			ml = optOrg.get().getMemberships();
			ml.removeIf(m -> m.getId().equals(membershipId));
			optOrg.get().setMemberships(ml);
			this.organizationRepository.save(optOrg.get());
		}
		
		membershipRepository.deleteById(membershipId);
	}
}
