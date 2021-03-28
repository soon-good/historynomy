package io.historynomy.serviceapi.marketindex.kospi.repository;

import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface KospiRepository extends ReactiveMongoRepository<Kospi, LocalDateTime> {

}
