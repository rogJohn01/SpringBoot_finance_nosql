package com.example.finance_nosql.domain;
import java.time.Instant;
import java.util.Date;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "stock_prices")
public class StockPrice {
    @Id
    private String id;
    private String stockSymbol;
    private Integer price;
    private Instant date;
    
    // getters and setters

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
