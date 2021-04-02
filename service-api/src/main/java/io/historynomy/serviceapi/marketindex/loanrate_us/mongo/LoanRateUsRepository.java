package io.historynomy.serviceapi.marketindex.loanrate_us.mongo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRateUsRepository extends MongoRepository<LoanRateUs, String> {
	List<LoanRateUs> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
