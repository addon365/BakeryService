package com.addon.BakeryService.errors;

public class CustomError {
	private String message;
	

	public CustomError() {
		super();
	}

	public CustomError(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
