package com.bcs.stocks.ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
public class StocksServiceUi {


    @RequestMapping(
            value = "/calculation",
            method = RequestMethod.GET,
            headers = "Accept=application/json")
    public String calculation() {
        return "";
    }
}
