package com.aidid.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aidid.entity.SolidarityHistory;

public interface SolidarityHistoryRepository extends JpaRepository<SolidarityHistory, Long> {

	
	}
