package com.mutant.dna.exceptions;

public class ErrorException extends BadRequestException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2238529290583542387L;
	private static final String DESCRIPTION = "Error en aplicacion : ";
	
	public ErrorException(String detail) {
		super(DESCRIPTION + " . " + detail);
	}

}
