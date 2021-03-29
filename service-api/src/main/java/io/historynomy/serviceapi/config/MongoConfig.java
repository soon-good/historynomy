package io.historynomy.serviceapi.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories({"io.historynomy.serviceapi.**.mongo"})
public class MongoConfig extends AbstractMongoClientConfiguration {
//public class MongoConfig {

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;

	@Override
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString(mongoUri);

		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
			.applyConnectionString(connectionString)
			.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Override
	protected String getDatabaseName() {
		return "market_index";
	}
}
