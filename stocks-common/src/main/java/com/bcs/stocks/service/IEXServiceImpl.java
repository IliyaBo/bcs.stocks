package com.bcs.stocks.service;

import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.entity.Symbol;
import com.bcs.stocks.model.stock.StockDto;
import com.bcs.stocks.model.stock.StocksDto;
import com.bcs.stocks.service.cashing.IEXCashSymbols;
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
    private IEXCashSymbols cashSymbols;

    @Override
    public List<AllocationDto> getAllocations(StocksDto stocks) {
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
            while (fieldNames.hasNext()) {
                Symbol symbol = null;
                //JsonNode to symbol


                JsonNode symbolNode = root.path("symbol");
                JsonNode sectorNode = root.path("sector");
                JsonNode lastSalePriceNode = root.path("lastSalePrice");
                String symbolStr = symbolNode.asText();

                if(StringUtils.isEmpty(cashSymbols.getCashSymbol().get(symbolStr))){
                    cashSymbols.getCashSymbol().put(symbolStr, symbol);
                }
            }

        } catch (Exception ex) {
            //log.info(ExceptionUtil.getStackTraceAsString());
            ex.printStackTrace();
        }
        return null;
    }

    private void fillMap(Map<String, BigDecimal> sectorAndAssertValue, JsonNode sector, JsonNode lastSalePrice) {
       /* if(sectorAndAssertValue.get()){

        }*/
    }
}
