package com.scrotify.medicalclaim.exception;

public class ClaimIdNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClaimIdNotFoundException (String message) {
		super(message);
	}

}
