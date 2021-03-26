package io.historynomy.serviceapi.marketindex.kospi;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface KospiRepository extends ReactiveMongoRepository<Kospi, LocalDateTime> {

}
