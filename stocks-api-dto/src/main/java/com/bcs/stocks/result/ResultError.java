package com.bcs.stocks.result;

public enum ResultError {
  INTERNAL_ERROR("500", "Internal Server Error. Details:");

  private String code;
  private String message;

  ResultError(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
