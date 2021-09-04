package com.aidid.service;

import java.util.List;
import java.util.Optional;

import com.aidid.dto.MembershipDto;
import com.aidid.entity.Membership;

public interface MembershipService {
	
	
    List<Membership> findAll();
    
    Optional<Membership> findById(Long id);
    
    Optional<Membership> findByMembership(String membership);

    void delete(Long id);

	Membership save(MembershipDto membership);


}
