package com.mutant.dna.request;

import java.util.Arrays;

public class TestSubject {
	
	private String[] dna;

	
	public String[] getDna() {
		return dna;
	}
	
	public void setDna(String[] dna) {
		this.dna = dna;
	}

	
	@Override
	public String toString() {
		return "TestSubject [dna=" + Arrays.toString(dna) + "]";
	}

}
