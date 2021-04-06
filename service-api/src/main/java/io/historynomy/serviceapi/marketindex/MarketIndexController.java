package io.historynomy.serviceapi.marketindex;

import io.historynomy.serviceapi.marketindex.dto.DollarBasedDto;
import io.historynomy.serviceapi.marketindex.dto.IndexDto;
import io.historynomy.serviceapi.marketindex.dto.KospiBasedDto;
import io.historynomy.serviceapi.marketindex.dto.PercentDto;
import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.kospi.KospiService;
import io.historynomy.serviceapi.marketindex.loanrate_kr.LoanRateKrService;
import io.historynomy.serviceapi.marketindex.loanrate_us.LoanRateUsService;
import io.historynomy.serviceapi.marketindex.won_dollar_rate.WonDollarRateService;
import io.historynomy.serviceapi.marketindex.yuan_dollar_rate.YuanDollarRateService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketIndexController {

	private final KospiService kospiService;

	private final LoanRateUsService loanRateUsService;

	private final LoanRateKrService loanRateKrService;

	private final WonDollarRateService wonDollarRateService;

	private final YuanDollarRateService yuanDollarRateService;

	@Autowired
	public MarketIndexController(
		KospiService kospiService, LoanRateKrService loanRateKrService, LoanRateUsService loanRateUsService,
		WonDollarRateService wonDollarRateService, YuanDollarRateService yuanDollarRateService){
		this.kospiService = kospiService;
		this.loanRateKrService = loanRateKrService;
		this.loanRateUsService = loanRateUsService;
		this.wonDollarRateService = wonDollarRateService;
		this.yuanDollarRateService = yuanDollarRateService;
	}

	@GetMapping("/market-index/kospi-based-index")
	public KospiBasedDto getKospiBasedIndex(
		@RequestParam("startDate") String strStartDate, @RequestParam("endDate") String strEndDate
	){
		LocalDateTime startDate = LocalDate
			.parse(strStartDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		LocalDateTime endDate = LocalDate
			.parse(strEndDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<IndexDto> kospiList = kospiService.findAllByTimeBetween(startDate, endDate);
		List<PercentDto> loanRateKrList = loanRateKrService.findAllByTimeBetween(startDate, endDate);
		List<PercentDto> loanRateUsList = loanRateUsService.findAllByTimeBetween(startDate, endDate);

		KospiBasedDto resultDto = KospiBasedDto.builder()
			.kospi(kospiList)
			.loanRateKr(loanRateKrList)
			.loanRateUs(loanRateUsList)
			.build();

		return resultDto;
	}

	@GetMapping("/market-index/dollar-based-index")
	public DollarBasedDto getDollarBasedIndex(
		@RequestParam("startDate") String strStartDate, @RequestParam("endDate") String strEndDate
	){
		LocalDateTime startDate = LocalDate
			.parse(strStartDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		LocalDateTime endDate = LocalDate
			.parse(strEndDate, DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();

		List<PriceDto> wonDollarList = wonDollarRateService.findAllByTimeBetween(startDate, endDate);
		List<PriceDto> yuanDollarList = yuanDollarRateService.findAllByTimeBetween(startDate, endDate);

		DollarBasedDto resultDto = DollarBasedDto.builder()
			.wonDollar(wonDollarList)
			.yuanDollar(yuanDollarList)
			.build();

		return resultDto;
	}

}
