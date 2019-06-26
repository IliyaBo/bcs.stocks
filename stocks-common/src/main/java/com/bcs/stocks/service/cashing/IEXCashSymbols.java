package com.bcs.stocks.service.cashing;

import com.bcs.stocks.model.entity.Symbol;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class IEXCashSymbols {

    @Getter
    Map<String, Symbol> cashSymbol = new ConcurrentHashMap<>();

    abstract void updateCash(List<Symbol> symbols);
}
