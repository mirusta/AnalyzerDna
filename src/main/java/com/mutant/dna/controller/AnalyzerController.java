package com.mutant.dna.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mutant.dna.exceptions.ForbiddenException;
import com.mutant.dna.request.TestSubject;
import com.mutant.dna.response.Response;
import com.mutant.dna.service.DnaService;
import com.mutant.dna.service.StatsService;

@RestController
@CrossOrigin(origins = "*")

public class AnalyzerController {
	
	private  final Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired
	private DnaService dnaService;
	
	@Autowired
	private StatsService statSevice;
	
	@RequestMapping(method = RequestMethod.POST, value = "/mutant")
	public ResponseEntity<Response> mutant(@RequestBody TestSubject subject) {	
		
		log.info("Inicio de proceso verificar adn");
		
		if(dnaService.isMutant(subject.getDna())) {
			log.info("es mutante");
			return ResponseEntity.ok(new Response(true, "MUTANTE"));
		} 			
		
			log.info("es humano");
			throw new ForbiddenException("HUMANO");
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/stats")
	public ResponseEntity<Response> stats() {
		log.info("Inicio de proceso stats adn");
		Response response = statSevice.getStats();	
		response.setSuccess(true);
		response.setMessage("estadistica");		
		return ResponseEntity.ok(response);		
	}
}
