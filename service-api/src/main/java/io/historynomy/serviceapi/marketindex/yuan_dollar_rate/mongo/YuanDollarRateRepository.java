package io.historynomy.serviceapi.marketindex.yuan_dollar_rate.mongo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface YuanDollarRateRepository extends MongoRepository<YuanDollarRate, String> {
	List<YuanDollarRate> findAllByTimeBetween(LocalDateTime start, LocalDateTime end);
}
