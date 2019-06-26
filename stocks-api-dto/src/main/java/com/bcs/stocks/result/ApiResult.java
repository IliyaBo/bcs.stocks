package com.bcs.stocks.result;

import java.util.ArrayList;
import java.util.Collection;

public class ApiResult<T> implements IApiResult<T> {
    private static final long serialVersionUID = 1L;

    private T result;
    private ApiResultStatus status;
    private Collection<IApiResultError> errors;

    public ApiResult(T result) {
        this.result = result;
        status = ApiResultStatus.SUCCESS;
    }

    public ApiResult(Collection<IApiResultError> errors) {
        this.errors = errors;
        status = ApiResultStatus.ERROR;
    }

    public ApiResult(IApiResultError error) {
        addError(error);
        this.status = ApiResultStatus.ERROR;
    }

    public ApiResult(T result, ApiResultStatus status) {
        this.result = result;
        this.status = status;
    }

    public ApiResult(T result, ApiResultStatus status, Collection<IApiResultError> errors) {
        this.result = result;
        this.status = status;
        this.errors = errors;
    }

    @Override
    public T getResult() {
        if (status == ApiResultStatus.ERROR) {
            //todo add custom Exception
            throw new RuntimeException();
        }

        return result;
    }

    @Override
    public T getResultWithoutCheck() {
        return result;
    }

    @Override
    public ApiResultStatus getStatus() {
        return status;
    }

    @Override
    public Collection<IApiResultError> getErrors() {
        return errors;
    }

    public void addError(IApiResultError error) {
        if (errors == null) {
            errors = new ArrayList<>();
        }

        errors.add(error);
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "result=" + result +
                ", status=" + status +
                ", errors=" + errors +
                '}';
    }
}
