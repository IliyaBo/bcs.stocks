package com.bcs.stocks.service.request;

import com.bcs.stocks.model.stock.StockDto;
import com.bcs.stocks.model.stock.StocksDto;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class RequestUtil {

  public static ResponseEntity<String> getSymbols(StocksDto stocks) {
    String param = null;
    if (stocks != null) {
      param = stocks.getStocks().stream().map(StockDto::getSymbol).collect(Collectors.joining(","));
    }
    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl;
    if (!StringUtils.isEmpty(param)) {
      resourceUrl = String.format("https://api.iextrading.com/1.0/tops?symbols=%s", param);
    } else {
      resourceUrl = "https://api.iextrading.com/1.0/tops";
    }
    ResponseEntity<String> response
        = restTemplate.getForEntity(resourceUrl, String.class);
    return response;
  }
}
