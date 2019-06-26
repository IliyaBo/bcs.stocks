package com.bcs.stocks.service.cashing;

import com.bcs.stocks.model.entity.Symbol;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class IEXCashingSymbolsImpl extends IEXCashSymbols {


    @Override
    public void updateCash(List<Symbol> symbols) {

    }

    @Override
    public Map<String, Symbol> getCashSymbol() {
        return super.getCashSymbol();
    }
}
