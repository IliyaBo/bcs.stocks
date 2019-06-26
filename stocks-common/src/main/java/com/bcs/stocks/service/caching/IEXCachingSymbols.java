package com.bcs.stocks.service.caching;

import com.bcs.stocks.model.entity.Symbol;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class IEXCachingSymbols {

    @Getter
    Map<String, Symbol> cacheSymbol = new ConcurrentHashMap<>();

    abstract void updateCache(List<Symbol> symbols);
}
