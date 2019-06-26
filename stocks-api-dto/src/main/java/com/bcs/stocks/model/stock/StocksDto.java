package com.bcs.stocks.model.stock;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class StocksDto implements Serializable {

  @Getter
  @Setter
  private List<StockDto> stocks;

  public StocksDto() {
    //no-args
  }

  public StocksDto(List<StockDto> stocks) {
    this.stocks = stocks;
  }

}
