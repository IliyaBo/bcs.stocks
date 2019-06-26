package com.bcs.stocks.service;

import com.bcs.stocks.exception.ExceptionUtil;
import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.CalculateDto;
import com.bcs.stocks.model.entity.Symbol;
import com.bcs.stocks.model.stock.StockDto;
import com.bcs.stocks.model.stock.StocksDto;
import com.bcs.stocks.service.search.ISearchSymbols;
import com.bcs.stocks.service.search.caching.IEXCachingSymbolsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Slf4j
@Service
public class IEXServiceImpl implements IEXService {

    private IEXCachingSymbolsImpl searchSymbols;

    @Autowired
    public void setSearchSymbols(IEXCachingSymbolsImpl searchSymbols) {
        this.searchSymbols = searchSymbols;
    }

    @Override
    public CalculateDto calculateBySector(StocksDto stocks) {
        Map<String, BigDecimal> sectorAndAssertValue = new HashMap<>();
        List<Symbol> symbols = new ArrayList<>();

        try {
            for(StockDto stockDto: stocks.getStocks()){
                String symbolStr = stockDto.getSymbol();
                if (StringUtils.isEmpty(searchSymbols.getSymbols().get(symbolStr))) {
                    //todo custom exceptions
                    searchSymbols.updateCache();
                    log.info("cache is not empty? " + !searchSymbols.getSymbols().isEmpty());
                } else {
                    symbols.add(searchSymbols.getSymbols().get(symbolStr));
                }
            }
            fillMap(sectorAndAssertValue, stocks, symbols);

            return calculateBySectorAndProportion(sectorAndAssertValue);

        } catch (Exception ex) {
            log.error(ExceptionUtil.getStackTraceAsString(ex));
            //todo custom exceptions
            throw new RuntimeException("Error during process of calculate stocks");
        }
    }

    /**
     * Calculate sector and sum
     *
     * @param sectorAndAssertValue map: sector and sum
     * @param stocks dto from ui
     * @param symbols symbols from some repository
     */
    private void fillMap(Map<String, BigDecimal> sectorAndAssertValue, StocksDto stocks, List<Symbol> symbols) {
        for (Symbol symbol : symbols) {
            BigDecimal sum = BigDecimal.ZERO;
            Optional<StockDto> foundStockDto = stocks.getStocks().stream()
                    .filter(stockDto -> stockDto.getSymbol().equals(symbol.getSymbol()))
                    .findFirst();
            if (foundStockDto.isPresent()) {
                sum = sum.add(symbol.getLastSalePrice().multiply(BigDecimal.valueOf(foundStockDto.get().getVolume())));
            }

            if (sectorAndAssertValue.get(symbol.getSector()) == null) {
                sectorAndAssertValue.put(symbol.getSector(), symbol.getLastSalePrice());
            } else {
                sectorAndAssertValue.put(symbol.getSector(), sum.add(sectorAndAssertValue.get(symbol.getSector())));
            }
        }
    }

    private CalculateDto calculateBySectorAndProportion(Map<String, BigDecimal> sectorAndAssertValue){
        CalculateDto calculateDto = new CalculateDto();
        List<AllocationDto> allocations = new ArrayList<>();

        BigDecimal sumValue = BigDecimal.ZERO;
        for (Map.Entry<String, BigDecimal> entry : sectorAndAssertValue.entrySet()) {
            sumValue = sumValue.add(entry.getValue());
        }
        calculateDto.setValue(sumValue);

        for (Map.Entry<String, BigDecimal> entry : sectorAndAssertValue.entrySet()) {
            AllocationDto allocation = new AllocationDto();
            allocation.setSector(entry.getKey());
            allocation.setAssetValue(entry.getValue());
            allocation.setProportion(entry.getValue().divide(sumValue, RoundingMode.HALF_EVEN));
            allocations.add(allocation);
        }
        calculateDto.setAllocations(allocations);
        return calculateDto;
    }
}
