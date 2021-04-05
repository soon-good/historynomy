package io.historynomy.serviceapi.marketindex.won_dollar_rate;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.won_dollar_rate.mongo.WonDollarRate;
import io.historynomy.serviceapi.marketindex.won_dollar_rate.mongo.WonDollarRateRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WonDollarRateServiceImpl implements WonDollarRateService{

	private final WonDollarRateRepository wonDollarRateRepository;

	@Autowired
	public WonDollarRateServiceImpl(WonDollarRateRepository wonDollarRateRepository){
		this.wonDollarRateRepository = wonDollarRateRepository;
	}

	@Override
	public List<PriceDto> findAllByTimeBetween(LocalDateTime start, LocalDateTime end) {
		List<WonDollarRate> wondDollarList = wonDollarRateRepository
			.findAllByTimeBetween(start, end);

		return wondDollarList.stream()
			.map(wonDollarRate -> {
				return PriceDto.builder()
					.dataName(wonDollarRate.getDataName())
					.dataValue(wonDollarRate.getDataValue())
					.time(wonDollarRate.getTime())
					.build();
			})
			.collect(Collectors.toList());
	}
}
