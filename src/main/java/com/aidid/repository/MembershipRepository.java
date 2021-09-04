package com.aidid.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aidid.entity.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

}
