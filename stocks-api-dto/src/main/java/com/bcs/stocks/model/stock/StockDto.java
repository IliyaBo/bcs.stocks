package com.bcs.stocks.model.stock;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class StockDto implements Serializable {

  @Getter
  @Setter
  private String symbol;

  @Getter
  @Setter
  private Integer volume;

  public StockDto() {
    //no-args
  }

  public StockDto(String symbol, Integer volume) {
    this.symbol = symbol;
    this.volume = volume;
  }
}
