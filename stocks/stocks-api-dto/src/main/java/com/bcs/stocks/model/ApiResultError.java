package com.bcs.stocks.model;

public class ApiResultError implements IApiResultError {
    private static final long serialVersionUID = 1L;

    private String code;
    private String message;

    public ApiResultError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
