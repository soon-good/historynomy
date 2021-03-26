package io.historynomy.serviceapi.marketindex.kospi;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "kospi")
public class Kospi {

	@Id
	private String id;

	@Field(name = "TIME")
	private LocalDateTime localDateTime;

	@Field(name = "DATA_VALUE")
	private Double dataValue;

	@Field(name = "ITEM_NAME1")
	private String dataName;


	@Field(name = "UNIT_NAME")
	private String unitName;

	@Field(name = "STAT_CODE")
	private String topCategory;

	@Field(name = "ITEM_CODE1")
	private String midCategory;

	@Field(name = "STAT_NAME")
	private String statDesc;


	@Field(name = "ITEM_CODE2")
	private String itemCodeTwo;

	@Field(name = "ITEM_CODE3")
	private String itemCodeThree;

	@Field(name = "ITEM_NAME2")
	private String itemNameTwo;

	@Field(name = "ITEM_NAME3")
	private String itemNameThree;

	public Kospi(String dataName, Double dataValue){
		this.dataName = dataName;
		this.dataValue = dataValue;
	}

}
