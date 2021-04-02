package io.historynomy.serviceapi.marketindex.loanrate_us;

import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import java.time.LocalDateTime;
import java.util.List;

public interface LoanRateUsService {
	List<PercentDto> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
