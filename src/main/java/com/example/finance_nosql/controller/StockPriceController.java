package com.example.finance_nosql.controller;

import com.example.finance_nosql.domain.StockPrice;
import com.example.finance_nosql.service.StockPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockPriceController {
    private final StockPriceService stockPriceService;
    private static final Logger LOGGER = LoggerFactory.getLogger(StockPriceController.class);

    public StockPriceController(StockPriceService stockPriceService) {
        this.stockPriceService = stockPriceService;
    }

    @GetMapping("/{stockSymbol}")
    public ResponseEntity<List<StockPrice>> getStockPrices(@PathVariable String stockSymbol) {
        List<StockPrice> stockPrices = stockPriceService.getStockPrices(stockSymbol);
        if(stockPrices.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(stockPrices, HttpStatus.OK);
        }
    }

    @PostMapping("/stock-prices")
    public StockPrice addStockPrice(@RequestBody StockPrice newStockPrice) {
        StockPrice createdStockPrice = stockPriceService.saveStockPrice(newStockPrice);
        LOGGER.info("Added new stock price for {} to the database.", createdStockPrice.getStockSymbol());
        return createdStockPrice;
    }
}
