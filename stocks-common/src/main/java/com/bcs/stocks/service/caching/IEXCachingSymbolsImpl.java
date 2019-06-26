package com.bcs.stocks.service.caching;

import com.bcs.stocks.model.entity.Symbol;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class IEXCachingSymbolsImpl extends IEXCachingSymbols {


    @Override
    public void updateCache(List<Symbol> symbols) {

    }

    @Override
    public Map<String, Symbol> getCacheSymbol() {
        return super.getCacheSymbol();
    }
}
