package io.historynomy.serviceapi.marketindex.loanrate_us;

import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import io.historynomy.serviceapi.marketindex.loanrate_us.mongo.LoanRateUs;
import io.historynomy.serviceapi.marketindex.loanrate_us.mongo.LoanRateUsRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanRateUsServiceImpl implements LoanRateUsService {

	private final LoanRateUsRepository loanRateUsRepository;

	@Autowired
	public LoanRateUsServiceImpl(LoanRateUsRepository loanRateUsRepository){
		this.loanRateUsRepository = loanRateUsRepository;
	}

	@Override
	public List<PercentDto> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate) {

		List<LoanRateUs> result = loanRateUsRepository.findAllByTimeBetween(startDate, endDate);

		return result.stream()
			.map(l -> {
				return PercentDto.builder()
					.time(l.getTime())
					.dataName(l.getDataName())
					.dataValue(l.getDataValue())
					.build();
			})
			.collect(Collectors.toList());
	}
}
