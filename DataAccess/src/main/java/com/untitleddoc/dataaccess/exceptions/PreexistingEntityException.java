package com.untitleddoc.dataaccess.exceptions;

public class PreexistingEntityException extends Exception {

	private static final long serialVersionUID = 438357107514397629L;
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
