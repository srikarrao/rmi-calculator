package com.rmi.calculator.server;

public class Result implements java.io.Serializable{

	// variable to check the valid calculation
	private boolean isValid;
	
	// variable to return the output
	private Double outputResult;
	// variable to display the error message
	private String message; 
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public Double getOutputResult() {
		return outputResult;
	}
	public void setOutputResult(Double outputResult) {
		this.outputResult = outputResult;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
