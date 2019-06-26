package com.bcs.stocks.result;

import lombok.ToString;

@ToString
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

}
