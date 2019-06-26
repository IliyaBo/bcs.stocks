package com.bcs.stocks.ui.controller;

import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.StockDto;
import com.bcs.stocks.service.IEXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StocksServiceUi {

    private IEXService iexService;

    @Autowired
    public void setIexService(IEXService iexService) {
        this.iexService = iexService;
    }

    @RequestMapping(
            value = "/calculation",
            method = RequestMethod.GET)
    public String calculation() {
        return "AAAA";
    }


    @RequestMapping(
            value = "/symbols",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public  List<AllocationDto> symbols(@RequestBody List<StockDto> stocks) {

        return iexService.getAllocations(stocks);
    }
}
