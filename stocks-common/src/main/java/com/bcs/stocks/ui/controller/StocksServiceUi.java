package com.bcs.stocks.ui.controller;

import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.stock.StocksDto;
import com.bcs.stocks.service.IEXService;
/*import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/
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


    /*@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})*/
    @RequestMapping(
            value = "/symbols",
            method = RequestMethod.POST,
            headers = "Accept=application/json")
    public  List<AllocationDto> symbols(@RequestBody StocksDto stocks) {

        return iexService.getAllocations(stocks);
    }
}
