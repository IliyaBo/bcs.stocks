package com.bcs.stocks.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
public class StockDto implements Serializable{

    @Getter
    @Setter
    private String symbol;

    @Getter
    @Setter
    private String volume;
}
