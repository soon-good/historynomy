package io.historynomy.serviceapi.marketindex.loanrate_kr;

import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import io.historynomy.serviceapi.marketindex.loanrate_kr.mongo.LoanRateKr;
import io.historynomy.serviceapi.marketindex.loanrate_kr.mongo.LoanRateKrRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class LoanRateKrServiceImpl implements LoanRateKrService {

	private LoanRateKrRepository loanRateKrRepository;

	public LoanRateKrServiceImpl(LoanRateKrRepository loanRateKrRepository){
		this.loanRateKrRepository = loanRateKrRepository;
	}

	@Override
	public List<PercentDto> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate) {
		List<LoanRateKr> result = loanRateKrRepository
			.findAllByTimeBetween(startDate, endDate);

		return result.stream()
			.map(l -> {
				return PercentDto.builder()
					.time(l.getTime())
					.dataName(l.getDataName())
					.dataValue(l.getDataValue())
					.build();
			})
			.collect(
			Collectors.toList());
	}
}
