package com.bcs.stocks.service.search.realTime;

import com.bcs.stocks.model.entity.Symbol;
import com.bcs.stocks.model.stock.StocksDto;
import com.bcs.stocks.service.search.ISearchSymbols;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Real time mode
 */
@Component(ISearchSymbols.SEARCH_FROM_QUEUE_REQUESTS)
public class IEXQueueSymbolsImpl implements ISearchSymbols {

    ConcurrentLinkedQueue<StocksDto> requests = new ConcurrentLinkedQueue<>();

    //ThreadLocal

    //добавляем в общую очередь каждый запрос

    //потоками разгружаем очредь

    //семафор для ограничения кол-ва запросов в секунду

    @Override
    public Map<String, Symbol> getSymbols() {
        throw new UnsupportedOperationException("RealTime mode not supported");
    }
}
