package com.bcs.stocks.result;

import java.io.Serializable;
import java.util.Collection;

public interface IApiResult<T> extends Serializable {

  T getResult();

  T getResultWithoutCheck();

  ApiResultStatus getStatus();

  Collection<IApiResultError> getErrors();
}
