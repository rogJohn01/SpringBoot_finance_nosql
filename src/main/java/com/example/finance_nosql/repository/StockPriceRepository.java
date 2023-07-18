package com.example.finance_nosql.repository;

import com.example.finance_nosql.domain.StockPrice;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockPriceRepository extends MongoRepository<StockPrice, String> {
    @Query("{}")
    List<StockPrice> findAll();
    List<StockPrice> findByStockSymbol(String stockSymbol);
    void deleteByStockSymbol(String stockSymbol);
}
