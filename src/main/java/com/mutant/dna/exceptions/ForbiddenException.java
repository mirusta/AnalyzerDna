package com.mutant.dna.exceptions;

public class ForbiddenException extends RuntimeException {

	/**
		 * 
		 */
	private static final long serialVersionUID = 4818054901117471812L;
	private static final String DESCRIPTION = "Forbidden Exception (403)";

	public ForbiddenException(String detail) {
		super(DESCRIPTION + " . " + detail);
	}
}
