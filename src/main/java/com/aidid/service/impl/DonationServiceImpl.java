package com.aidid.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidid.dto.DonationDto;
import com.aidid.entity.Donation;
import com.aidid.entity.Organization;
import com.aidid.entity.SolidarityHistory;
import com.aidid.repository.CollaboratorRepository;
import com.aidid.repository.DonationRepository;
import com.aidid.repository.OrganizationRepository;
import com.aidid.repository.SolidarityHistoryRepository;
import com.aidid.service.DonationService;

@Service
@Transactional
public class DonationServiceImpl implements DonationService {

	@Autowired
	DonationRepository donationRepository;
	
	@Autowired
	SolidarityHistoryRepository solidarityHistoryRepository;
	
	@Autowired
	CollaboratorRepository collaboratorRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	
	@Override
	public Donation save(DonationDto donationDto) {
		
		List<Donation> donations = null;
		Donation m=null;
		Optional<SolidarityHistory> os = solidarityHistoryRepository.findById(donationDto.getIdSolidarityHistory());
		Donation donationSave = this.donationRepository.save(donationDto.getDonation());
		
		if(os.isPresent())
		{
			donations = os.get().getDonations();
			donations.add(donationSave);
			os.get().setDonations(donations);
			this.solidarityHistoryRepository.save(os.get());
			donationSave.setSolidarityHistoryId(os.get().getId());
			
		}
		
		Optional<Organization> optOrg = organizationRepository.findById(donationDto.getIdOrganization());
		if(optOrg.isPresent())
		{
			donations = optOrg.get().getDonations();
			donations.add(donationSave);
			optOrg.get().setDonations(donations);
			this.organizationRepository.save(optOrg.get());
			donationSave.setOrganizationId(optOrg.get().getId());
			donationSave.setOrganizationUserName(optOrg.get().getUsername());
		}
		
		this.donationRepository.save(donationSave);
		
		return donationSave;
	}

	@Override
	public List<Donation> findAll() {
		// TODO Auto-generated method stub
		return donationRepository.findAll();
	}

	@Override
	public Optional<Donation> findById(Long id) {
		// TODO Auto-generated method stub
		return donationRepository.findById(id);
	}

	@Override
	public Optional<Donation> findByDonation(String donation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long donationId) {
		// TODO Auto-generated method stub
		List<Donation> donations = null;
		Optional<Donation> optDonation = this.donationRepository.findById(donationId);
		Optional<SolidarityHistory> os = null;
		if(optDonation.isPresent())
		{
			os = this.solidarityHistoryRepository.findById(optDonation.get().getSolidarityHistoryId());
		}
		
		
		if(os.isPresent())
		{
			donations = os.get().getDonations();
			donations.removeIf(d -> d.getId().equals(donationId));
			os.get().setDonations(donations);
			this.solidarityHistoryRepository.save(os.get());
		}
		
		Optional<Organization> optOrg = organizationRepository.findById(optDonation.get().getOrganizationId());
		if(optOrg.isPresent())
		{
			donations = optOrg.get().getDonations();
			donations.removeIf(d -> d.getId().equals(donationId));
			optOrg.get().setDonations(donations);
			this.organizationRepository.save(optOrg.get());
		}
		
		donationRepository.deleteById(donationId);
			
	}

}
