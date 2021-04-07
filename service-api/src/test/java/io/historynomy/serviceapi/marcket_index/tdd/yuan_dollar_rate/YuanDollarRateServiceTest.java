package io.historynomy.serviceapi.marcket_index.tdd.yuan_dollar_rate;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.yuan_dollar_rate.YuanDollarRateService;
import io.historynomy.serviceapi.marketindex.yuan_dollar_rate.mongo.YuanDollarRate;
import io.historynomy.serviceapi.marketindex.yuan_dollar_rate.mongo.YuanDollarRateRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class YuanDollarRateServiceTest {

	@Autowired
	YuanDollarRateService yuanDollarRateService;

	@Autowired
	YuanDollarRateRepository yuanDollarRateRepository;

	@Test
	@DisplayName("Repository_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다")
	void Repository_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다(){
		String startDate = "19600101";
		String endDate = "20210401";

		LocalDateTime start = LocalDate
			.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
		LocalDateTime end = LocalDate
			.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<YuanDollarRate> yuanDollarRateList = yuanDollarRateRepository
			.findAllByTimeBetween(start, end);

		List<PriceDto> yuanDollarRateResult = yuanDollarRateList.stream().map(yuanDollarRate -> {
			return PriceDto.builder()
				.dataName(yuanDollarRate.getDataName())
				.dataValue(yuanDollarRate.getDataValue())
				.time(yuanDollarRate.getTime())
				.build();
		}).collect(Collectors.toList());

		Assertions.assertThat(yuanDollarRateResult).isNotEmpty();
	}

	@Test
	@DisplayName("Service_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다")
	void Service_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다(){
		String startDate = "19600101";
		String endDate = "20210401";

		LocalDateTime start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
		LocalDateTime end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<PriceDto> yuanDollarRateResult = yuanDollarRateService.findAllByTimeBetween(start, end);

		Assertions.assertThat(yuanDollarRateResult).isNotEmpty();
	}
}
