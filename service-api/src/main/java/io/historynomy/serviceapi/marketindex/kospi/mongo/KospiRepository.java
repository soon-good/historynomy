package io.historynomy.serviceapi.marketindex.kospi.mongo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KospiRepository extends MongoRepository<Kospi, String> {
	public List<Kospi> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
