package com.mutant.dna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutant.dna.entity.TabDna;
import com.mutant.dna.repository.DnaRepository;
import com.mutant.dna.response.ResponseStats;
import com.mutant.dna.service.StatsService;

@Service
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	private DnaRepository repository;

	@Override
	public ResponseStats getStats() {
	
	ResponseStats respose = new ResponseStats();

	List<TabDna> dnaList = repository.findAll();
	
	respose.setCount_mutant_dna( dnaList.stream().filter(d-> d.isDnaIsMutant()).count()); 
	respose.setCount_human_dna( dnaList.stream().filter(d-> !d.isDnaIsMutant()).count()); 
	
	if (respose.getCount_human_dna() > 0) {
		Double ratio = (double) (respose.getCount_mutant_dna() / respose.getCount_human_dna());
		respose.setRatio(ratio.toString());
	} else {
		respose.setRatio(respose.getCount_mutant_dna() + " : " + respose.getCount_human_dna());
	}
						
	return respose;
	}

}
