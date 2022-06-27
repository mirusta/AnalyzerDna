package com.mutant.dna.exceptions;

public class AlreadyExistsException extends BadRequestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5198025464479728115L;
	private static final String DESCRIPTION = "Already Exists Exception (400)";

	public AlreadyExistsException(String detail) {
		super(DESCRIPTION + " . " + detail);
	}
	
}
