package io.historynomy.serviceapi.marketindex.dto;

import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import io.historynomy.serviceapi.marketindex.loanrate_kr.mongo.LoanRateKr;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
public class IndexDto {

	private LocalDateTime time;

	private String dataName;

	private Double dataValue;

	@Builder
	public IndexDto(LocalDateTime time, String dataName, Double dataValue){
		this.time = time;
		this.dataName = dataName;
		this.dataValue = dataValue;
	}

	public static IndexDto of(Kospi kospi){
		return null;
	}

	public static IndexDto of(LoanRateKr loanRateKr){
		return null;
	}
}
