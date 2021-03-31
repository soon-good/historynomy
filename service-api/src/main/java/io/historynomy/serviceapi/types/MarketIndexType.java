package io.historynomy.serviceapi.types;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import java.util.function.Function;

public enum MarketIndexType {
	KOSPI("KOSPI", 10000){
		@Override
		public Function<Kospi, PriceDto> mapToDto(){
			return t -> {
				return PriceDto.builder()
					.dataValue(t.getDataValue())
					.dataName(t.getDataName())
					.time(t.getTime())
					.build();
			};
		}
	},
	KOSDAQ("KOSDAQ", 10001){
		@Override
		public <T, R> Function<T, R> mapToDto() {
			return null;
		}
	},
	LOAN_RATE_KR("LOAN_RATE_KR", 20001){
		@Override
		public <LoanRateKr, PercentDto> Function<LoanRateKr, PercentDto> mapToDto() {
			return null;
		}
	},
	LOAN_RATE_US("LOAN_RATE_US", 20001){
		@Override
		public <LoanRateUs, PercentDto> Function<LoanRateUs, PercentDto> mapToDto() {
			return null;
		}
	},
	EXCHANGE_RATE_WON_DOLLAR("EXCHANGE_RATE_WON_DOLLAR", 30001){
		@Override
		public <T, R> Function<T, R> mapToDto() {
			return null;
		}
	},
	EXCHANGE_RATE_YUAN_DOLLAR("EXCHANGE_RATE_YUAN_DOLLAR", 30002){
		@Override
		public <T, R> Function<T, R> mapToDto() {
			return null;
		}
	};

	public abstract <T,R> Function<T,R> mapToDto();

	private String indexTypeNm;

	private int indexTypeCd;

	MarketIndexType(String indexTypeNm, int indexTypeCd){
		this.indexTypeNm = indexTypeNm;
		this.indexTypeCd = indexTypeCd;
	}

}
