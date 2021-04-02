package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.dto.IndexDto;
import java.time.LocalDateTime;
import java.util.List;

public interface KospiService {
	List<IndexDto> findAll();
	List<IndexDto> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
