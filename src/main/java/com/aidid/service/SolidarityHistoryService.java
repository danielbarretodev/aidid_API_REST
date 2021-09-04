package com.aidid.service;

import java.util.List;
import java.util.Optional;

import com.aidid.entity.SolidarityHistory;

public interface SolidarityHistoryService {

	SolidarityHistory save(SolidarityHistory solidarityHistory);

    List<SolidarityHistory> findAll();
    
    Optional<SolidarityHistory> findById(Long id);
    
    void delete(Long id);
}
