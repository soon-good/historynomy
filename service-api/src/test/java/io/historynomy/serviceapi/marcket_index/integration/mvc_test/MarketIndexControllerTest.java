package io.historynomy.serviceapi.marcket_index.integration.mvc_test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.historynomy.serviceapi.marketindex.kospi.KospiService;
import io.historynomy.serviceapi.marketindex.loanrate_kr.LoanRateKrService;
import io.historynomy.serviceapi.marketindex.loanrate_us.LoanRateUsService;
import io.historynomy.serviceapi.marketindex.won_dollar_rate.WonDollarRateService;
import io.historynomy.serviceapi.marketindex.yuan_dollar_rate.YuanDollarRateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class MarketIndexControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private KospiService kospiService;

	@Autowired
	private LoanRateUsService loanRateUsService;

	@Autowired
	private LoanRateKrService loanRateKrService;

	@Autowired
	private WonDollarRateService wonDollarRateService;

	@Autowired
	private YuanDollarRateService yuanDollarRateService;

	@Test
	@DisplayName("코스피관련_경제지표_컨트롤러_MockMvc_테스트")
	void 코스피관련_경제지표_컨트롤러_MockMvc_테스트() throws Exception {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("startDate", "19600101");
		param.add("endDate", "20211231");
		mockMvc.perform(
				MockMvcRequestBuilders
					.get("/market-index/kospi-based-index")
					.params(param))
			.andExpect(status().isOk())
			.andDo(print());
	}

	@Test
	@DisplayName("달러기반_경제지표_컨트롤러_MockMvc_테스트")
	void 달러기반_경제지표_컨트롤러_MockMvc_테스트() throws Exception {
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		param.add("startDate", "19600101");
		param.add("endDate", "20211231");
		mockMvc.perform(
			MockMvcRequestBuilders
				.get("/market-index/dollar-based-index")
				.params(param)
		).andExpect(status().isOk())
			.andDo(print());
	}
}
