package com.bcs.stocks.service;

import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.stock.StocksDto;

import java.util.List;

/**
 * Service for getting data from IEX
 */
public interface IEXService {

    /**
     * Pull stocks from cache or realTime and prepare allocations
     *
     * @param stocks dto from user's request
     * @param fromCache take stocks from cache or in realTime mode
     * @return custom allocation dto
     */
    List<AllocationDto> getAllocationsFrom(StocksDto stocks, Boolean fromCache);
}
