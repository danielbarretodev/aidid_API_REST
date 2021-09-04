package com.aidid.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidid.entity.SolidarityHistory;
import com.aidid.repository.SolidarityHistoryRepository;
import com.aidid.service.SolidarityHistoryService;

@Service
@Transactional
public class SolidarityHistoryServiceImpl implements SolidarityHistoryService {

	@Autowired
	SolidarityHistoryRepository solidarityHistoryRepository;
	
	@Override
	public SolidarityHistory save(SolidarityHistory solidarityHistory) {
		// TODO Auto-generated method stub
		return solidarityHistoryRepository.save(solidarityHistory);
	}

	@Override
	public List<SolidarityHistory> findAll() {
		// TODO Auto-generated method stub
		return solidarityHistoryRepository.findAll();
	}

	@Override
	public Optional<SolidarityHistory> findById(Long id) {
		// TODO Auto-generated method stub
		return solidarityHistoryRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		solidarityHistoryRepository.deleteById(id);
	}
}
