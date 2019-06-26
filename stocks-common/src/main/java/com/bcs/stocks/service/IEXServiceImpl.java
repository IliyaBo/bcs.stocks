package com.bcs.stocks.service;

import com.bcs.stocks.model.AllocationDto;
import com.bcs.stocks.model.StockDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IEXServiceImpl implements IEXService{

    @Override
    public List<AllocationDto> getAllocations(List<StockDto> stocks) {
        Map<String, BigDecimal> sectorAndAssertValue = new HashMap<>();
        List<AllocationDto> allocations = new ArrayList<>();

        String param = stocks.stream().map(StockDto::getSymbol).collect(Collectors.joining(","));
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = String.format("https://api.iextrading.com/1.0/tops?symbols=%s", param);
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(response.getBody());
            Iterator<String> fieldNames = root.fieldNames();
            while (fieldNames.hasNext()) {
                JsonNode sector = root.path("sector");
                JsonNode lastSalePrice = root.path("lastSalePrice");
                log.info(sector.asText());
                log.info(lastSalePrice.asText());
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    private void fillMap(Map<String, BigDecimal> sectorAndAssertValue, JsonNode sector, JsonNode lastSalePrice){
       /* if(sectorAndAssertValue.get()){

        }*/
    }
}
