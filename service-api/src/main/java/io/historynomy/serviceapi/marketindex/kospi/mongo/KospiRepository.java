package io.historynomy.serviceapi.marketindex.kospi.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface KospiRepository extends MongoRepository<Kospi, String> {
}
