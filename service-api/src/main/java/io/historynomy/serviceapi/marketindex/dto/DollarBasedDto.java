package io.historynomy.serviceapi.marketindex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DollarBasedDto {

	@JsonProperty("wonDollar")
	private List<PriceDto> wonDollar;

	@JsonProperty("yuanDollar")
	private List<PriceDto> yuanDollar;

	@Builder
	public DollarBasedDto(List<PriceDto> wonDollar, List<PriceDto> yuanDollar){
		this.wonDollar = wonDollar;
		this.yuanDollar = yuanDollar;
	}
}
