package io.historynomy.serviceapi.loanrate_us;

import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import io.historynomy.serviceapi.marketindex.loanrate_us.LoanRateUsService;
import io.historynomy.serviceapi.marketindex.loanrate_us.mongo.LoanRateUs;
import io.historynomy.serviceapi.marketindex.loanrate_us.mongo.LoanRateUsRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoanRateUsServiceTest {

	@Autowired
	LoanRateUsService loanRateUsService;

	@Autowired
	LoanRateUsRepository loanRateUsRepository;

	@Test
	void 테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다(){
		String startDate = "19600101";
		String endDate = "20210401";

		LocalDateTime start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
		LocalDateTime end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<LoanRateUs> byTime = loanRateUsRepository.findAllByTimeBetween(start, end);

		List<PercentDto> result = byTime.stream().map(l -> {
			return PercentDto.builder()
				.time(l.getTime())
				.dataName(l.getDataName())
				.dataValue(l.getDataValue())
				.build();
		}).collect(Collectors.toList());

		result.forEach(System.out::println);
		Assertions.assertThat(result).isNotEmpty();
	}

	@Test
	void 메서드_테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다(){
		String startDate = "19600101";
		String endDate = "20210401";

		LocalDateTime start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
		LocalDateTime end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<PercentDto> result = loanRateUsService.findAllByTimeBetween(start, end);

		Assertions.assertThat(result).isNotEmpty();
	}
}