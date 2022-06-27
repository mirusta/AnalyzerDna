package com.mutant.dna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mutant.dna.response.ResponseStats;
import com.mutant.dna.service.DnaService;
import com.mutant.dna.service.StatsService;

/**
 * @author EDGAR CONTRERAS
 *
 */
@SpringBootTest
public class AnalyzerDnaApplicationTests {

	@Autowired
	private DnaService dnaService;

	@Autowired
	private StatsService statsService;

	@Test
	void contextLoads() throws Exception {

	}

/*
	@Test
	void isHumanOrIsAlreadyExist() throws Exception {
		String[] dnaH = { "AAAAAA", "TCCTTC", "GTCTGG", "TGTTTG", "ACAGTA", "ACTCAG" };
		try {
		boolean esMutante = dnaService.isMutant(dnaH);
		assertFalse(esMutante);
		} catch (Exception ex) {
			assertEquals(
					"Bad Request Exception (400) . Already Exists Exception (400) . Cadena analizada, isMutant : false",
					ex.getMessage());
		}
	}

	@Test
	void isMutantOrIsAlreadyExist() throws Exception {
		String[] dnaM = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		try {
			boolean esMutante = dnaService.isMutant(dnaM);
			assertTrue(esMutante);
		} catch (Exception ex) {
		 		assertEquals(
					"Bad Request Exception (400) . Already Exists Exception (400) . Cadena analizada, isMutant : true",
					ex.getMessage());
		}

	}

	@Test
	void dnaCharacterError() throws Exception {
		String[] dnaError = { "BTGCGA", "CAGRGC", "TTATXT", "AGAAGG", "CJCCTA", "TCACTG" };
		try {
			dnaService.isMutant(dnaError);
		} catch (Exception ex) {
			assertEquals("Bad Request Exception (400) . Caracter No valido en secuencia", ex.getMessage());
		}
	}

	@Test
	void dnaSizeError() throws Exception {
		String[] dnaError = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA" };
		try {
			dnaService.isMutant(dnaError);
		} catch (Exception ex) {
			assertEquals("Bad Request Exception (400) . Cantidad de cadenas de adn , no validas ", ex.getMessage());
		}
	}

	@Test
	void dnaLengthError() throws Exception {
		String[] dnaError = { "ATGCA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		try {
			dnaService.isMutant(dnaError);
		} catch (Exception ex) {
			assertEquals("Bad Request Exception (400) . longitud de cadenas de adn , no validas ", ex.getMessage());
		}
	}

	@Test
	void ratio() throws Exception {

		ResponseStats stats = statsService.getStats();

		System.out.println(stats.toString());

	}
	
	*/

}
