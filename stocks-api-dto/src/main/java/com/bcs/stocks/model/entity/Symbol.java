package com.bcs.stocks.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@ToString
public class Symbol implements Serializable {

    @Getter
    @Setter
    private String symbol;

    @Getter
    @Setter
    private String sector;

    @Getter
    @Setter
    private String securityType;

    @Getter
    @Setter
    private BigDecimal bidPrice;

    @Getter
    @Setter
    private Integer bidSize;

    @Getter
    @Setter
    private BigDecimal askPrice;

    @Getter
    @Setter
    private Integer askSize;

    @Getter
    @Setter
    private Long lastUpdated;

    @Getter
    @Setter
    private BigDecimal lastSalePrice;

    @Getter
    @Setter
    private Integer lastSaleSize;

    @Getter
    @Setter
    private Long lastSaleTime;

    @Getter
    @Setter
    private Long volume;

    @Getter
    @Setter
    private BigDecimal marketPercent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        if (!symbol.equals(symbol1.symbol)) return false;
        if (!sector.equals(symbol1.sector)) return false;
        if (!securityType.equals(symbol1.securityType)) return false;
        if (!bidPrice.equals(symbol1.bidPrice)) return false;
        if (!bidSize.equals(symbol1.bidSize)) return false;
        if (!askPrice.equals(symbol1.askPrice)) return false;
        if (!askSize.equals(symbol1.askSize)) return false;
        if (!lastUpdated.equals(symbol1.lastUpdated)) return false;
        if (!lastSalePrice.equals(symbol1.lastSalePrice)) return false;
        if (!lastSaleSize.equals(symbol1.lastSaleSize)) return false;
        if (!lastSaleTime.equals(symbol1.lastSaleTime)) return false;
        if (!volume.equals(symbol1.volume)) return false;
        return marketPercent.equals(symbol1.marketPercent);
    }

    @Override
    public int hashCode() {
        int result = symbol.hashCode();
        result = 31 * result + sector.hashCode();
        result = 31 * result + securityType.hashCode();
        result = 31 * result + bidPrice.hashCode();
        result = 31 * result + bidSize.hashCode();
        result = 31 * result + askPrice.hashCode();
        result = 31 * result + askSize.hashCode();
        result = 31 * result + lastUpdated.hashCode();
        result = 31 * result + lastSalePrice.hashCode();
        result = 31 * result + lastSaleSize.hashCode();
        result = 31 * result + lastSaleTime.hashCode();
        result = 31 * result + volume.hashCode();
        result = 31 * result + marketPercent.hashCode();
        return result;
    }
}
