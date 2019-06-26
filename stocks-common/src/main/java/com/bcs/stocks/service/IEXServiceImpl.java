package com.bcs.stocks.service;

import com.bcs.stocks.exception.ExceptionUtil;
import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.entity.Symbol;
import com.bcs.stocks.model.stock.StockDto;
import com.bcs.stocks.model.stock.StocksDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IEXServiceImpl implements IEXService {

    @Autowired
    private com.bcs.stocks.service.caching.IEXCachingSymbols cacheSymbols;

    @Override
    public List<AllocationDto> getAllocationsFrom(StocksDto stocks, Boolean fromCache) {
        Map<String, BigDecimal> sectorAndAssertValue = new HashMap<>();
        List<AllocationDto> allocations = new ArrayList<>();
        List<Symbol> symbols = new ArrayList<>();

        try {
            String param = stocks.getStocks().stream().map(StockDto::getSymbol).collect(Collectors.joining(","));
            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl
                    = String.format("https://api.iextrading.com/1.0/tops?symbols=%s", param);
            ResponseEntity<String> response
                    = restTemplate.getForEntity(resourceUrl, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = null;

            root = mapper.readTree(response.getBody());
            Iterator<String> fieldNames = root.fieldNames();

            //get stocks from cache
            while (fieldNames.hasNext()) {

                JsonNode symbolNode = root.path("symbol");
                JsonNode sectorNode = root.path("sector");
                JsonNode lastSalePriceNode = root.path("lastSalePrice");
                String symbolStr = symbolNode.asText();

                if (StringUtils.isEmpty(cacheSymbols.getCacheSymbol().get(symbolStr))) {
                    //todo custom exceptions
                    throw new RuntimeException("Stock not found from cache: " + symbolStr);
                } else {
                    symbols.add(cacheSymbols.getCacheSymbol().get(symbolStr));
                }
            }

            //filling the map : abbreviation and sum
            for (Symbol symbol : symbols) {
                BigDecimal sum = BigDecimal.ZERO;
                Optional<StockDto> foundStockDto = stocks.getStocks().stream()
                        .filter(stockDto -> stockDto.getSymbol().equals(symbol.getSymbol()))
                        .findFirst();
                if (foundStockDto.isPresent()) {
                    sum.add(symbol.getLastSalePrice().multiply(BigDecimal.valueOf(foundStockDto.get().getVolume())));
                }

                if (sectorAndAssertValue.get(symbol.getSector()) == null) {
                    sectorAndAssertValue.put(symbol.getSector(), symbol.getLastSalePrice());
                } else {
                    sectorAndAssertValue.put(symbol.getSector(), sum.add(sectorAndAssertValue.get(symbol.getSector())));
                }
            }


        } catch (Exception ex) {
            log.error(ExceptionUtil.getStackTraceAsString(ex));
            //todo custom exceptions
            throw new RuntimeException("Error during process of calculate stocks");
        }
        return null;
    }

    private void fillMap(Map<String, BigDecimal> sectorAndAssertValue, JsonNode sector, JsonNode lastSalePrice) {
       /* if(sectorAndAssertValue.get()){

        }*/
    }
}
