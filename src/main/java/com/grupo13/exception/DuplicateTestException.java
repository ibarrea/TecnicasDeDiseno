package com.grupo13.exception;

public class DuplicateTestException extends IllegalStateException {

	private static final long serialVersionUID = -447569848345636775L;

    public DuplicateTestException(String message)
    {
       super(message);
    }
}
