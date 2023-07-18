package com.example.finance_nosql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.finance_nosql.domain.StockPrice;
import com.example.finance_nosql.repository.StockPriceRepository;

import java.util.List;
@Service 
public class StockPriceService {

    @Autowired
    private StockPriceRepository repository;

    @Cacheable(value = "stockPrices", key = "#stockSymbol")
    public List<StockPrice> getStockPrices(String stockSymbol) {
        return repository.findByStockSymbol(stockSymbol);
    }
    

    @CachePut(value = "stockPrice", key = "#stockPrice.stockSymbol")
    public StockPrice saveStockPrice(StockPrice stockPrice) {
        return repository.save(stockPrice);
    }

    @CacheEvict(value = "stockPrice", key = "#root.args[0]")
    public void deleteStockPrice(String stockSymbol) {
        repository.deleteByStockSymbol(stockSymbol);
    }

    @Cacheable(value = "allStockPrices")
    public List<StockPrice> findAll() {
        return repository.findAll();
    }
}
