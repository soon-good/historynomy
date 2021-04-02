package io.historynomy.serviceapi.marketindex.kospi;

import io.historynomy.serviceapi.marketindex.dto.IndexDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KospiController {

	private final KospiService kospiService;

	@Autowired
	public KospiController(KospiService kospiService){
		this.kospiService = kospiService;
	}

	@GetMapping("/market_index/kospi/all")
	public List<IndexDto> findKospiList(){
		List<IndexDto> allKospiHistory = kospiService.findAll();
		return allKospiHistory;
	}

	@GetMapping("/market_index/kospi")
	public List<IndexDto> findAllByTimeBetween(
		@RequestParam("startDate") LocalDateTime startDate, @RequestParam("endDate") LocalDateTime endDate
	){
		List<IndexDto> result = kospiService.findAllByTimeBetween(startDate, endDate);
		return result;
	}
}
