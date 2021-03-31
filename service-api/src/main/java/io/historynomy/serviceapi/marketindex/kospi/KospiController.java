package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KospiController {

	private final KospiService kospiService;

	@Autowired
	public KospiController(KospiService kospiService){
		this.kospiService = kospiService;
	}

	@GetMapping("/market_index/kospi/all")
	public List<PriceDto> getKospiList(){
		List<PriceDto> allKospiHistory = kospiService.findAll();
		return allKospiHistory;
	}
}
