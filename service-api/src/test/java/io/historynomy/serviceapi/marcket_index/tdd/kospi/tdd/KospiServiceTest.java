package io.historynomy.serviceapi.marcket_index.tdd.kospi.tdd;

import io.historynomy.serviceapi.marketindex.dto.IndexDto;
import io.historynomy.serviceapi.marketindex.kospi.KospiService;
import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import io.historynomy.serviceapi.marketindex.kospi.mongo.KospiRepository;
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
public class KospiServiceTest {

	@Autowired
	KospiService kospiService;

	@Autowired
	KospiRepository kospiRepository;

	@Test
	void 테스트_findAllByTimeBetween_데이터가_비어있지_않아야한다(){
		String startDate = "19600101";
		String endDate = "20210401";

		LocalDateTime start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
		LocalDateTime end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<Kospi> byTime = kospiRepository.findAllByTimeBetween(start, end);

		List<IndexDto> result = byTime.stream().map(kospi -> {
			return IndexDto.builder()
				.time(kospi.getTime())
				.dataName(kospi.getDataName())
				.dataValue(kospi.getDataValue())
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

		List<IndexDto> result = kospiService.findAllByTimeBetween(start, end);

		Assertions.assertThat(result).isNotEmpty();
	}
}
