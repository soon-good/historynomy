package io.historynomy.serviceapi.marketindex.loanrate_kr;

import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import java.time.LocalDateTime;
import java.util.List;

public interface LoanRateKrService {

	List<PercentDto> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
