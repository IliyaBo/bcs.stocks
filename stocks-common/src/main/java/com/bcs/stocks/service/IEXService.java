package com.bcs.stocks.service;

import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.stock.StocksDto;

import java.util.List;

/**
 * Service for getting data from IEX
 */
public interface IEXService {

    List<AllocationDto> getAllocations(StocksDto stocks);
}
