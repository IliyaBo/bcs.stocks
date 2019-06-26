package com.bcs.stocks.ui.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class StocksServiceUiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void check() throws Exception {
        this.mockMvc.perform(get("/api/stocks/check"))
                .andExpect(status().isOk())
                .andExpect(content().string("check"));
    }


    /*@Test
    public void calculateBySector() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/stocks-common-0.0.1-SNAPSHOT/api/stocks/calculateBySector"))
                .andExpect(status().isOk())
                .andExpect(content().string("good"));
    }*/

}