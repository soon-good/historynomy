package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import io.historynomy.serviceapi.marketindex.kospi.mongo.KospiRepository;
import io.historynomy.serviceapi.types.MarketIndexType;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KospiServiceImpl implements KospiService{

	private final KospiRepository kospiRepository;

	private final MarketIndexType INDEX_TYPE = MarketIndexType.KOSPI;

	@Autowired
	public KospiServiceImpl(KospiRepository kospiRepository){
		this.kospiRepository = kospiRepository;
	}

	@Override
	public List<PriceDto> findAll(){
		List<Kospi> all = kospiRepository.findAll();

		List<PriceDto> results = all.stream()
			.map(kospi -> {
				return (PriceDto) INDEX_TYPE.mapToDto().apply(kospi);
			})
			.collect(Collectors.toList());

		return results;
	}
}
