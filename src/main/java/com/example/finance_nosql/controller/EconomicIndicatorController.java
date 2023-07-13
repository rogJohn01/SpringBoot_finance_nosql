package com.example.finance_nosql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.finance_nosql.domain.EconomicIndicator;
import com.example.finance_nosql.repository.EconomicIndicatorRepository;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class EconomicIndicatorController {

    private final EconomicIndicatorRepository economicIndicatorRepository;

    public EconomicIndicatorController(EconomicIndicatorRepository economicIndicatorRepository) {
        this.economicIndicatorRepository = economicIndicatorRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(EconomicIndicatorController.class);

    @GetMapping("/economic-indicators")
    public List<EconomicIndicator> getEconomicIndicators() {
        try {
            List<EconomicIndicator> economicIndicators = economicIndicatorRepository.findAll();
            LOGGER.info("Fetched {} economic indicators from database.", economicIndicators.size());
            return economicIndicators;
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching economic indicators from database. Error Message: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @GetMapping("/economic-indicators/{indicatorName}")
    public List<EconomicIndicator> getEconomicIndicatorByName(@PathVariable String indicatorName) {
        try {
            List<EconomicIndicator> economicIndicators = economicIndicatorRepository.findByIndicatorName(indicatorName);
            LOGGER.info("Fetched {} economic indicators for {} from database.", economicIndicators.size(), indicatorName);
            return economicIndicators;
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching economic indicators for {} from database. Error Message: {}", indicatorName, e.getMessage(), e);
            return Collections.emptyList();
        }
    }

     @PostMapping("/economic-indicators")
    public EconomicIndicator addEconomicIndicator(@RequestBody EconomicIndicator newEconomicIndicator) {
        try {
            EconomicIndicator savedEconomicIndicator = economicIndicatorRepository.save(newEconomicIndicator);
            LOGGER.info("Saved new economic indicator to database: {}", savedEconomicIndicator);
            return savedEconomicIndicator;
        } catch (Exception e) {
            LOGGER.error("Error occurred while saving new economic indicator to database. Error Message: {}", e.getMessage(), e);
            return null;
        }
    }
}
