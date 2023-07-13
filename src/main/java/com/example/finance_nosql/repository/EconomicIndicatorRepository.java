package com.example.finance_nosql.repository;
import com.example.finance_nosql.domain.EconomicIndicator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EconomicIndicatorRepository extends MongoRepository<EconomicIndicator, String> {
    List<EconomicIndicator> findByIndicatorName(String indicatorName);
}
