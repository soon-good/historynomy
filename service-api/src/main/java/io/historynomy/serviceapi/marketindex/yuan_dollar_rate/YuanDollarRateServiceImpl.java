package io.historynomy.serviceapi.marketindex.yuan_dollar_rate;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.yuan_dollar_rate.mongo.YuanDollarRate;
import io.historynomy.serviceapi.marketindex.yuan_dollar_rate.mongo.YuanDollarRateRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YuanDollarRateServiceImpl implements YuanDollarRateService {

	private final YuanDollarRateRepository yuanDollarRateRepository;

	@Autowired
	public YuanDollarRateServiceImpl(YuanDollarRateRepository yuanDollarRateRepository){
		this.yuanDollarRateRepository = yuanDollarRateRepository;
	}

	@Override
	public List<PriceDto> findAllByTimeBetween(LocalDateTime start, LocalDateTime end) {
		List<YuanDollarRate> yuanDollarRateList = yuanDollarRateRepository
			.findAllByTimeBetween(start, end);

		return yuanDollarRateList.stream().map(yuanDollarRate -> {
			return PriceDto.builder()
				.dataName(yuanDollarRate.getDataName())
				.dataValue(yuanDollarRate.getDataValue())
				.time(yuanDollarRate.getTime())
				.build();
		}).collect(Collectors.toList());
	}
}
