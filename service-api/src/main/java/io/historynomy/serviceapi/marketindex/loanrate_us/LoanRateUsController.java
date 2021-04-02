package io.historynomy.serviceapi.marketindex.loanrate_us;

import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanRateUsController {

	private final LoanRateUsService loanRateUsService;

	@Autowired
	public LoanRateUsController(LoanRateUsService loanRateUsService){
		this.loanRateUsService = loanRateUsService;
	}

	@GetMapping("/market_index/loan_rate_us")
	public List<PercentDto> getAllByTimeBetween(
		@RequestParam("startDate") LocalDateTime startDate, @RequestParam("endDate")LocalDateTime endDate
	){
		List<PercentDto> result = loanRateUsService.findAllByTimeBetween(startDate, endDate);
		return result;
	}

}
