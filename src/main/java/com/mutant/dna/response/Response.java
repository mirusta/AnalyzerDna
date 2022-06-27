package com.mutant.dna.response;

public class Response {

	private Boolean success;
	private String message;

	public Response() {
		super();
	}

	public Response(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [success=" + success + ", message=" + message + "]";
	}

}
