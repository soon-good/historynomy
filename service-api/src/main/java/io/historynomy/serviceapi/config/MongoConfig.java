package io.historynomy.serviceapi.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories({"io.historynomy.serviceapi.**.mongo"})
public class MongoConfig extends AbstractReactiveMongoConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;

	@Override
	protected String getDatabaseName() {
		// TODO 데이터베이스명을 변경 vs 언더바 허용되도록 설정수정 둘중 하나를 선택해야 함 (참고::카멜케이스는 가독성이 떨어지짐)
		// application.yml 내에 입력되는 값 필드의 경우 언더바를 허용하지 않는 문제가 있다.
		// 이런 이유로 텍스트 값을 직접 명시해서 적어두는 것으로 임시조치함.
		return "market_index";
	}

	@Override
	public MongoClient reactiveMongoClient() {
		ConnectionString connectionString = new ConnectionString(mongoUri);

		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
			.applyConnectionString(connectionString)
			.build();

		return MongoClients.create(mongoClientSettings);
	}
}
