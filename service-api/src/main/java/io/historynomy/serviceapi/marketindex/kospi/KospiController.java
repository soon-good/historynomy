package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import io.historynomy.serviceapi.marketindex.kospi.repository.KospiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class KospiController {

	private KospiRepository kospiRepository;

	public KospiController(KospiRepository kospiRepository){
		this.kospiRepository = kospiRepository;
	}

	@GetMapping("/kospi/test")
	public Mono<Kospi> kospiTest(){
		Kospi k = new Kospi("코스피", 3500D);

		Mono<Kospi> dat = kospiRepository.insert(k);
		return dat;
	}
}
