package com.bcs.stocks.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CalculateDto implements Serializable {

  @Getter
  @Setter
  private BigDecimal value;

  @Getter
  @Setter
  private List<AllocationDto> allocations;

}
