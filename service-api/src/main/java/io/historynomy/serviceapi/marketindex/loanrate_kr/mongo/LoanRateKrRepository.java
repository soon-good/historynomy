package io.historynomy.serviceapi.marketindex.loanrate_kr.mongo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRateKrRepository extends MongoRepository<LoanRateKr, String> {

	List<LoanRateKr> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
