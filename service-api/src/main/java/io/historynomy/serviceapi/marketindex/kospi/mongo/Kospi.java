package io.historynomy.serviceapi.marketindex.kospi.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "kospi")
public class Kospi {

	@Id
	private String id;

	@Field(name = "TIME")
	private String time;
//	private LocalDateTime localDateTime;

	@Field(name = "ITEM_NAME1")
	private String dataName;

	@Field(name = "DATA_VALUE")
	private Double dataValue;

	@Field(name = "STAT_CODE")
	private String topCategory;

	@Field(name = "ITEM_CODE1")
	private String midCategory;

	@Field(name = "STAT_NAME")
	private String statDesc;


	// TODO 테스트 용도 (지우기)
	public Kospi(String dataName, Double dataValue){
		this.dataName = dataName;
		this.dataValue = dataValue;
	}

}
