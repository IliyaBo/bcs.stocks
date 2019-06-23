package com.bcs.stocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//scanBasePackages = {"com.bcs.stocks.ui.controller"}
@ComponentScan("com.bcs.stocks.ui.controller")
public class StocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksApplication.class, args);
	}

}
