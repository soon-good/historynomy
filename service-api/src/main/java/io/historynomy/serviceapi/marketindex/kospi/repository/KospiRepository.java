package io.historynomy.serviceapi.marketindex.kospi.repository;

import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface KospiRepository extends ReactiveMongoRepository<Kospi, String> {

	Flux<Kospi> findAll();
}
