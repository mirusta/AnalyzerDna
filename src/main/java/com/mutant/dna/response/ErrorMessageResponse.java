package com.mutant.dna.response;

public class ErrorMessageResponse extends Response {

	private String exception;
	private String path;

	public ErrorMessageResponse(Exception exception, String path) {
		super(false, exception.getMessage());
		this.exception = exception.getClass().getSimpleName();
		this.path = path;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
