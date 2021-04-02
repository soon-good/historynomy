package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.dto.IndexDto;
import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import io.historynomy.serviceapi.marketindex.kospi.mongo.KospiRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KospiServiceImpl implements KospiService{

	private final KospiRepository kospiRepository;

	@Autowired
	public KospiServiceImpl(KospiRepository kospiRepository){
		this.kospiRepository = kospiRepository;
	}

	@Override
	public List<IndexDto> findAll(){
		List<Kospi> all = kospiRepository.findAll();

		List<IndexDto> results = all.stream()
			.map(kospi -> {
				return IndexDto.builder()
					.time(kospi.getTime())
					.dataName(kospi.getDataName())
					.dataValue(kospi.getDataValue())
					.build();
			})
			.collect(Collectors.toList());

		return results;
	}

	@Override
	public List<IndexDto> findAllByTimeBetween(LocalDateTime startDate, LocalDateTime endDate) {
		List<Kospi> result = kospiRepository.findAllByTimeBetween(startDate, endDate);

		return result.stream()
			.map(kospi -> {
				return IndexDto.builder()
					.time(kospi.getTime())
					.dataName(kospi.getDataName())
					.dataValue(kospi.getDataValue())
					.build();
			})
			.collect(Collectors.toList());
	}
}
