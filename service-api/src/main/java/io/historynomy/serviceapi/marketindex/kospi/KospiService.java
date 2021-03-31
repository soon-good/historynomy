package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import java.util.List;

public interface KospiService {

	public List<PriceDto> findAll();
}
