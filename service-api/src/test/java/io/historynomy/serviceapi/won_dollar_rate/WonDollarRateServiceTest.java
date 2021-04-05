package io.historynomy.serviceapi.won_dollar_rate;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.won_dollar_rate.WonDollarRateService;
import io.historynomy.serviceapi.marketindex.won_dollar_rate.mongo.WonDollarRate;
import io.historynomy.serviceapi.marketindex.won_dollar_rate.mongo.WonDollarRateRepository;
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
public class WonDollarRateServiceTest {

	@Autowired
	private WonDollarRateService wonDollarRateService;

	@Autowired
	private WonDollarRateRepository wonDollarRateRepository;

	@Test
	@DisplayName("Repository_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다")
	void Repository_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다(){
		String startDate = "19600101";
		String endDate = "20210401";

		LocalDateTime start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
		LocalDateTime end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<WonDollarRate> wonDollarRateList = wonDollarRateRepository
			.findAllByTimeBetween(start, end);

		List<PriceDto> wonDollarResult = wonDollarRateList.stream().map(wonDollarRate -> {
			return PriceDto.builder()
				.dataValue(wonDollarRate.getDataValue())
				.dataName(wonDollarRate.getDataName())
				.time(wonDollarRate.getTime())
				.build();
		}).collect(Collectors.toList());

		Assertions.assertThat(wonDollarResult).isNotEmpty();
	}

	@Test
	@DisplayName("Service_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다")
	void Service_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다(){
		String startDate = "19600101";
		String endDate = "20210401";

		LocalDateTime start = LocalDate
			.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
		LocalDateTime end = LocalDate
			.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<PriceDto> wonDollarResult = wonDollarRateService.findAllByTimeBetween(start, end);
		Assertions.assertThat(wonDollarResult).isNotEmpty();
	}
}
