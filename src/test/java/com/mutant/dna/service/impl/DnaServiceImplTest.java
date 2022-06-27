/**
 * 
 */
package com.mutant.dna.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import com.mutant.dna.repository.DnaRepository;

/**
 * @author EDGAR CONTRERAS
 *
 */
@ExtendWith(MockitoExtension.class)
public class DnaServiceImplTest {
	@Mock
	private Environment env;

	@Mock
	private DnaRepository repository;
	@InjectMocks
	private DnaServiceImpl dnaServiceImpl;

	
	/**
	 * Test method for {@link com.mutant.dna.service.impl.DnaServiceImpl#isMutant(java.lang.String[])}.
	 */
	@Test
	public void testIsMutant() {
		throw new RuntimeException("not yet implemented");
	}

}
