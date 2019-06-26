package com.bcs.stocks.service.search.caching;

import com.bcs.stocks.model.entity.Symbol;
import com.bcs.stocks.service.request.RequestUtil;
import com.bcs.stocks.service.search.ISearchSymbols;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@EnableScheduling
@Component(ISearchSymbols.SEARCH_FROM_CACHE)
public class IEXCachingSymbolsImpl implements ISearchSymbols {

    @Getter
    Map<String, Symbol> symbols = new ConcurrentHashMap<>();

    @Scheduled(fixedRate = 10000)
    public void updateCache() {
        log.info("updateCache...");
        ResponseEntity<String> response = RequestUtil.getSymbols(null);

    }
}
