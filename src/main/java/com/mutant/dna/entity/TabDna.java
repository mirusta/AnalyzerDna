package com.mutant.dna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_DNA")
public class TabDna {

	@Id
	@Column(name = "dna_dna", nullable = false)
	private String dnaDna;
	@Column(name = "dna_is_mutant", nullable = false)
	private boolean dnaIsMutant;

	public TabDna() {
		super();
	}	 

	public TabDna(String dnaDna, boolean dnaIsMutant) {
		super();
		this.dnaDna = dnaDna;
		this.dnaIsMutant = dnaIsMutant;
	}
	 
	public String getDnaDna() {
		return dnaDna;
	}

	public void setDnaDna(String dnaDna) {
		this.dnaDna = dnaDna;
	}

	public boolean isDnaIsMutant() {
		return dnaIsMutant;
	}

	public void setDnaIsMutant(boolean dnaIsMutant) {
		this.dnaIsMutant = dnaIsMutant;
	}

	@Override
	public String toString() {
		return "TabDna [dnaDna=" + dnaDna + ", dnaIsMutant=" + dnaIsMutant + "]";
	}

	
}
