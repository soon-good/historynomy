package io.historynomy.serviceapi.marketindex.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
public class PriceDto {
	private LocalDateTime time;

	private String dataName;

	private Double dataValue;

	@Builder
	public PriceDto(LocalDateTime time, String dataName, Double dataValue){
		this.time = time;
		this.dataName = dataName;
		this.dataValue = dataValue;
	}
}
