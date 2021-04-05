package io.historynomy.serviceapi.marketindex.yuan_dollar_rate.mongo;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "exchange_rate_yuan_dollar")
public class YuanDollarRate {

	@Id
	private String id;

	@Field(name = "time")
	private LocalDateTime time;

	@Field(name = "dataName")
	private String dataName;

	@Field(name = "dataValue")
	private Double dataValue;

	@Field(name = "topCategory")
	private String topCategory;

	@Field(name = "midCategory")
	private String midCategory;

	@Field(name = "statDesc")
	private String statDesc;
}
