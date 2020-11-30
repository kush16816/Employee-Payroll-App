package com.capgemini.employeepayrollapp.exception;

public class EmpException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    int errorCode;
    String message;

    public EmpException(String errorMessage)
    {
        super(errorMessage);
    }
    public EmpException(int errorCode, String message)
    {
        this(message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
