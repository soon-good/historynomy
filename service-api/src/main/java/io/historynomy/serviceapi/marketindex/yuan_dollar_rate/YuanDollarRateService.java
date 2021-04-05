package io.historynomy.serviceapi.marketindex.yuan_dollar_rate;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import java.time.LocalDateTime;
import java.util.List;

public interface YuanDollarRateService {
	List<PriceDto> findAllByTimeBetween(LocalDateTime start, LocalDateTime end);
}
