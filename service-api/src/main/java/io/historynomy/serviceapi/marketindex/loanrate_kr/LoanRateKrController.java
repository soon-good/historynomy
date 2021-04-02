package io.historynomy.serviceapi.marketindex.loanrate_kr;

import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanRateKrController {

	private LoanRateKrService loanRateKrService;

	@Autowired
	public LoanRateKrController(LoanRateKrService loanRateKrService){
		this.loanRateKrService = loanRateKrService;
	}

	@GetMapping("/market_index/loan_rate_kr")
	public List<PercentDto> getLoanRateKr(
		@RequestParam("startDate")LocalDateTime startDate, @RequestParam("endDate") LocalDateTime endDate){

		List<PercentDto> result = loanRateKrService.findAllByTimeBetween(startDate, endDate);

		return result;
	}
}
