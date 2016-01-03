package com.untitleddoc.dataaccess.exceptions;

public class NonexistentEntityException extends Exception {

	private static final long serialVersionUID = -3046210384013106247L;
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
