package com.example.finance_nosql.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finance_nosql.domain.StockPrice;
import com.example.finance_nosql.repository.StockPriceRepository;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class StockPriceController {

    private final StockPriceRepository stockPriceRepository;

    public StockPriceController(StockPriceRepository stockPriceRepository) {
        this.stockPriceRepository = stockPriceRepository;
    }

private static final Logger LOGGER = LoggerFactory.getLogger(StockPriceController.class);


@GetMapping("/stock-prices")
public List<StockPrice> getStockPrices(@RequestParam(required = false) String stockSymbol) {
    try {
        List<StockPrice> stockPrices;
        if (stockSymbol != null) {
            stockPrices = stockPriceRepository.findByStockSymbol(stockSymbol);
            LOGGER.info("Fetched {} stock prices for symbol {} from database.", stockPrices.size(), stockSymbol);
        } else {
            stockPrices = stockPriceRepository.findAll();
            LOGGER.info("Fetched {} stock prices from database. and symbol null", stockPrices.size());
        }
        return stockPrices;
    } catch (Exception e) {
        LOGGER.error("Error occurred while fetching stock prices from database.", e);
        return Collections.emptyList();
    }
}



 @PostMapping("/stock-prices")
    public StockPrice addStockPrice(@RequestBody StockPrice newStockPrice) {
        StockPrice createdStockPrice = stockPriceRepository.save(newStockPrice);
        LOGGER.info("Added new stock price for {} to the database.", createdStockPrice.getStockSymbol());
        return createdStockPrice;
    }


}
