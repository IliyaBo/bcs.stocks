package com.bcs.stocks.service.search;

import com.bcs.stocks.model.entity.Symbol;
import java.util.Map;

public interface ISearchSymbols {

  String SEARCH_FROM_CACHE = "SearchFromCache";
  String SEARCH_FROM_QUEUE_REQUESTS = "SearchFromQueue";


  Map<String, Symbol> getSymbols();

}
