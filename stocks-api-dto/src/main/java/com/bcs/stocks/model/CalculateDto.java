package com.bcs.stocks.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class CalculateDto implements Serializable {

    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private List<AllocationDto> allocations;

}
