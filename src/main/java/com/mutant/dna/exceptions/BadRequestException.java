package com.mutant.dna.exceptions;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3966751506171525722L;
	private static final String DESCRIPTION = "Bad Request Exception (400)";

	public BadRequestException(String detail) {
		super(DESCRIPTION + " . " + detail );
	}

	 
}
