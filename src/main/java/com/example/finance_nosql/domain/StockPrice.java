package com.example.finance_nosql.domain;
import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@Document(collection = "stock_prices")
public class StockPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty("id") // Jackson annotation for JSON serialization
    private String id;
    
    @JsonProperty("stock_symbol")
    private String stockSymbol;
    
    @JsonProperty("price")
    private Integer price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    @JsonProperty("date")
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
