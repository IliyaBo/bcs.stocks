package com.bcs.stocks.service;

import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.StockDto;

import java.util.List;

/**
 * Service for getting data from IEX
 */
public interface IEXService {

    List<AllocationDto> getAllocations(List<StockDto> stocks);
}
