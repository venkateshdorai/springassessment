package com.paintcolour.springassessment.api;

public class ColorNameMismatchException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ColorNameMismatchException(String message) {
        super(message);
    }

}
