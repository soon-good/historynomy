package io.historynomy.serviceapi.marketindex.won_dollar_rate.mongo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WonDollarRateRepository extends MongoRepository<WonDollarRate, String> {
	List<WonDollarRate> findAllByTimeBetween(LocalDateTime start, LocalDateTime end);
}
