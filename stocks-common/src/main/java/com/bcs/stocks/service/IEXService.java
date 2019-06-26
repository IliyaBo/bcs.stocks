package com.bcs.stocks.service;

import com.bcs.stocks.model.CalculateDto;
import com.bcs.stocks.model.stock.StocksDto;

/**
 * Service for getting data from IEX
 */
public interface IEXService {

  /**
   * Pull stocks from some repository and calculate by sector
   *
   * @param stocks dto from user's request
   * @return custom calculateDto
   */
  CalculateDto calculateBySector(StocksDto stocks);
}
