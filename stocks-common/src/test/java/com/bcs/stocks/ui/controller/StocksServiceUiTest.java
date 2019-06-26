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
    public void calculation() throws Exception {
        this.mockMvc.perform(get("/api/stocks/calculation"))
                .andExpect(status().isOk())
                .andExpect(content().string("AAAA"));
    }

    /*
    @Test
    public void cal() throws Exception {
        this.mockMvc.perform(get("https://api.iextrading.com/1.0/tops?symbols=SNAP"))
                .andExpect(status().isOk())
                .andExpect(content().string("good"));
    }*/

}