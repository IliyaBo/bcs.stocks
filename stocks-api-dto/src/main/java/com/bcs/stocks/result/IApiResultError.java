package com.bcs.stocks.result;

import java.io.Serializable;

public interface IApiResultError extends Serializable{
    String getCode();

    String getMessage();
}
