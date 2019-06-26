package com.bcs.stocks;

import com.bcs.stocks.model.stock.StockDto;
import com.bcs.stocks.model.stock.StocksDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTest {

    @Test
    public void dtoToJson() throws IOException {
        List<StockDto> stockList = new ArrayList<>();
        stockList.add(new StockDto("AAPL", 50));
        StocksDto stocks = new StocksDto(stockList);

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(stocks);
        System.out.println(jsonStr);
    }
}
