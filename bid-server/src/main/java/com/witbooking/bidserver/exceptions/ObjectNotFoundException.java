package com.witbooking.bidserver.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    private String message;
    private String code;

    public ObjectNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
