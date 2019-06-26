package com.bcs.stocks.service.search.caching;

import com.bcs.stocks.exception.ExceptionUtil;
import com.bcs.stocks.model.entity.Symbol;
import com.bcs.stocks.service.request.RequestUtil;
import com.bcs.stocks.service.search.ISearchSymbols;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@EnableScheduling
@Component(ISearchSymbols.SEARCH_FROM_CACHE)
public class IEXCachingSymbolsImpl implements ISearchSymbols {

    @Getter
    Map<String, Symbol> symbols = new ConcurrentHashMap<>();

    //todo add to property or profile
    @Scheduled(fixedDelay = 100000)
    public void updateCache() {
        log.info("updateCache...");
        ResponseEntity<String> response = RequestUtil.getSymbols(null);
        try {
            getSymbols().clear();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            Iterator<JsonNode> nodes = root.iterator();
            while (nodes.hasNext()) {
                Symbol symbol = mapper.treeToValue(nodes.next(), Symbol.class);
                getSymbols().put(symbol.getSymbol(), symbol);
            }
        }catch (Exception ex){
            log.error("Error during update the cache:" + ExceptionUtil.getStackTraceAsString(ex));
        }
    }
}
