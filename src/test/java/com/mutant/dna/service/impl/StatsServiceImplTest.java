/**
 * 
 */
package com.mutant.dna.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mutant.dna.repository.DnaRepository;

/**
 * @author EDGAR CONTRERAS
 *
 */
@ExtendWith(MockitoExtension.class)
public class StatsServiceImplTest {
	@Mock
	private DnaRepository repository;
	@InjectMocks
	private StatsServiceImpl statsServiceImpl;

	/**
	 * Test method for {@link com.mutant.dna.service.impl.StatsServiceImpl#getStats()}.
	 */
	@Test
	public void testGetStats() {
		throw new RuntimeException("not yet implemented");
	}

}
