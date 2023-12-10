package com.app.util;

public class InternalException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Integer errorNum;

    public InternalException(Integer errorNum, String message) {
        super(message);
        this.errorNum = errorNum;
    }
    
    public Integer getErrorNum() {
    	return errorNum;
    }
}