package com.example.finance_nosql.domain;
import java.time.Instant;
import java.util.Date;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "economic_indicators")
public class EconomicIndicator {
    @Id
    private String id;
    private String indicatorName;
    private Double value;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant date;

    public String getId() {
        return id;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public Double getValue() {
        return value;
    }

    public Instant getDate() {
        return date;
    }

    // setters
    public void setId(String id) {
        this.id = id;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
