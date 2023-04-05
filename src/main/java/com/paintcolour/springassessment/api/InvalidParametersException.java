package com.paintcolour.springassessment.api;

public class InvalidParametersException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidParametersException(String message) {
        super(message);
    }

}
