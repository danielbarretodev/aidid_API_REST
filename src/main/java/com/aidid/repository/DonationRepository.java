package com.aidid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aidid.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
