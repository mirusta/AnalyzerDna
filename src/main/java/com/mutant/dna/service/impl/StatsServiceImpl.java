package com.mutant.dna.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutant.dna.entity.TabDna;
import com.mutant.dna.exceptions.ErrorException;
import com.mutant.dna.repository.DnaRepository;
import com.mutant.dna.response.ResponseStats;
import com.mutant.dna.service.StatsService;

@Service
public class StatsServiceImpl implements StatsService {
	
	private  final Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	private DnaRepository repository;

	@Override
	public ResponseStats getStats() {

		ResponseStats respose = new ResponseStats();

		log.info("Obteniedo adn de la bd");
		List<TabDna> dnaList = null;
		try {
			dnaList = repository.findAll();
		} catch (Exception e) {
			log.info(e.getLocalizedMessage());
			throw new ErrorException("Error al consultar");
		}

		respose.setCount_mutant_dna(BigDecimal.valueOf(dnaList.stream().filter(d -> d.isDnaIsMutant()).count()));
		respose.setCount_human_dna(BigDecimal.valueOf(dnaList.stream().filter(d -> !d.isDnaIsMutant()).count()));

		log.info("Calcualndo ratio");
		if (respose.getCount_human_dna().intValue() > 0) {
			respose.setRatio(String.valueOf(respose.getCount_mutant_dna().divide(respose.getCount_human_dna())));
		} else {
			respose.setRatio(respose.getCount_mutant_dna() + " : " + respose.getCount_human_dna());
		}

		return respose;
	}

}
