package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import io.historynomy.serviceapi.marketindex.kospi.mongo.KospiRepository;
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
	public List<KospiDto> findAll(){
		List<Kospi> all = kospiRepository.findAll();

		List<KospiDto> results = all.stream()
			.map(kospi -> {
				return KospiDto.of(kospi);
			})
			.collect(Collectors.toList());

		return results;
	}
}
