package com.grupo13.exception;

public class Grupo13DuplicateTestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -447569848345636775L;

    //Parameterless Constructor
    public Grupo13DuplicateTestException() {}

    //Constructor that accepts a message
    public Grupo13DuplicateTestException(String message)
    {
       super(message);
    }
}
