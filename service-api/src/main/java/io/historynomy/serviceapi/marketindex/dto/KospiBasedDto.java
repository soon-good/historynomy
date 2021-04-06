package io.historynomy.serviceapi.marketindex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class KospiBasedDto {

	@JsonProperty("kospi")
	private List<IndexDto> kospi;

	@JsonProperty("loanRateKr")
	private List<PercentDto> loanRateKr;

	@JsonProperty("loanRateUs")
	private List<PercentDto> loanRateUs;

	@Builder
	public KospiBasedDto(List<IndexDto> kospi, List<PercentDto> loanRateKr, List<PercentDto> loanRateUs){
		this.kospi = kospi;
		this.loanRateKr = loanRateKr;
		this.loanRateUs = loanRateUs;
	}
}
