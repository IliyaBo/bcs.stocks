package com.bcs.stocks.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@ToString
public class AllocationDto implements Serializable{

    @Getter
    @Setter
    private String sector;

    @Getter
    @Setter
    private BigDecimal assetValue;

    @Getter
    @Setter
    private BigDecimal proportion;


}
