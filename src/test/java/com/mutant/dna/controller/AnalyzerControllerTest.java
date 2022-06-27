package com.mutant.dna.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.mutant.dna.request.TestSubject;
import com.mutant.dna.response.Response;
import com.mutant.dna.service.DnaService;
import com.mutant.dna.service.StatsService;

 
@RunWith(MockitoJUnitRunner.class)
public class AnalyzerControllerTest {

 	@Mock
	private DnaService dnaService;

	@Mock
	private StatsService statSevice;
	
	@InjectMocks
	private AnalyzerController analyzerController;
	
	private TestSubject subject;

	@BeforeEach
	protected void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		subject  = new TestSubject();
		
		
		
		String[] dnaH = {"AAAAAA","TCCTTC","GTCTGG","TGTTTG","ACAGTA","ACTCAG"};
		String[] dnaM = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		String[] dnaError = {"BTGCGA","CAGRGC","TTATXT","AGAAGG","CJCCTA","TCACTG"};
		String[] dnaRepetido = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		subject.setDna(dnaH);
		
	}

	@Test
	public void testMutant() {		
		when(analyzerController.mutant(subject)).thenReturn((ResponseEntity<Response>) status().isOk());
		verify(status().isOk());
		 
	}

	@Test
	public void testStats() {
		throw new RuntimeException("not yet implemented");
	}

}
