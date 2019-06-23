package com.bcs.stocks.model;

import java.io.Serializable;

public interface IApiResultError extends Serializable{
    String getCode();

    String getMessage();
}
