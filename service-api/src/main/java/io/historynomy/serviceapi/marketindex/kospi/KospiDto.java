package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
public class KospiDto {

	private LocalDateTime time;

	private String dataName;

	private Double dataValue;

	@Builder
	public KospiDto(LocalDateTime time, String dataName, Double dataValue){
		this.time = time;
		this.dataName = dataName;
		this.dataValue = dataValue;
	}

	public static KospiDto of (Kospi kospi){
		return KospiDto.builder()
			.time(kospi.getTime())
			.dataName(kospi.getDataName())
			.dataValue(kospi.getDataValue())
			.build();
	}

	@Override
	public String toString() {
		return "KospiDto{" +
			"time=" + time +
			", dataName='" + dataName + '\'' +
			", dataValue=" + dataValue +
			'}';
	}
}
