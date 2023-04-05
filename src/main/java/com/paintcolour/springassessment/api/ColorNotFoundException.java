package com.paintcolour.springassessment.api;

public class ColorNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ColorNotFoundException(String message) {
        super(message);
    }

}
