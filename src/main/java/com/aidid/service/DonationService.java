package com.aidid.service;

import java.util.List;
import java.util.Optional;

import com.aidid.dto.DonationDto;
import com.aidid.entity.Donation;

public interface DonationService {
	

    List<Donation> findAll();
    
    Optional<Donation> findById(Long id);
    
    Optional<Donation> findByDonation(String donation);

    void delete(Long id);

	Donation save(DonationDto donationDto);


}
