package com.bcs.stocks.ui.controller;

import com.bcs.stocks.exception.ExceptionUtil;
import com.bcs.stocks.model.CalculateDto;
import com.bcs.stocks.model.stock.StocksDto;
import com.bcs.stocks.result.ApiResult;
import com.bcs.stocks.result.ApiResultError;
import com.bcs.stocks.result.ResultError;
import com.bcs.stocks.service.IEXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
public class StocksServiceUi {

    private IEXService iexService;

    @Autowired
    public void setIexService(IEXService iexService) {
        this.iexService = iexService;
    }

    @RequestMapping(
            value = "/check",
            method = RequestMethod.GET)
    public String check() {
        return "check";
    }

    @RequestMapping(
            value = "/calculateBySector",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public ApiResult<CalculateDto> calculateBySector(@RequestBody StocksDto stocks) {
        try {
            return new ApiResult<>(iexService.calculateBySector(stocks));
            //todo catch custom exceptions
        } catch (Exception ex) {
            return new ApiResult<>(
                    new ApiResultError(ResultError.INTERNAL_ERROR.getCode(),
                            ResultError.INTERNAL_ERROR.getMessage() + ExceptionUtil.getStackTraceAsString(ex)));
        }
    }
}
