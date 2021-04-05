package io.historynomy.serviceapi.marketindex.won_dollar_rate;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import java.time.LocalDateTime;
import java.util.List;

public interface WonDollarRateService {
	public List<PriceDto> findAllByTimeBetween(LocalDateTime start, LocalDateTime end);
}
