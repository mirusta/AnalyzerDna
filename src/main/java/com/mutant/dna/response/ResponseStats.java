package com.mutant.dna.response;

import java.math.BigDecimal;

public class ResponseStats extends Response {

	private BigDecimal count_mutant_dna;
	private BigDecimal count_human_dna;
	private String ratio;
		
	public BigDecimal getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(BigDecimal count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public BigDecimal getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(BigDecimal count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public String getRatio() {
		return ratio;
	}
	
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "ResponseStats [count_mutant_dna=" + count_mutant_dna + ", count_human_dna=" + count_human_dna
				+ ", ratio=" + ratio + "]";
	}

}
