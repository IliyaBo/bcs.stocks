package com.bcs.stocks;

/**
 * Api call for stocks information
 */
public interface StockServiceApi {

  /**
   * Get the current stock portfolio value calculation and it's sectoral distribution
   */
  String calculation();
}
