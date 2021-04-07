package io.historynomy.serviceapi.marcket_index.integration.client_test;

import io.historynomy.serviceapi.marketindex.dto.KospiBasedDto;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

//@SpringBootTest
public class MarketIndexClientTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void 코스피기반_지표_테스트(){
		final String BASE_URL = "http://localhost";
		final String server_resource = "/market-index/kospi-based-index";

		StringBuilder requestUrlSb = new StringBuilder();
		
		requestUrlSb.append(BASE_URL)
			.append(server_resource)
			.append("?")
			.append("startDate=").append("19600101")
			.append("&")
			.append("endDate=").append("20211231");

		String requestUrl = requestUrlSb.toString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity request = new HttpEntity(headers);

		ResponseEntity<KospiBasedDto> response = restTemplate
			.exchange(requestUrl, HttpMethod.GET, request, KospiBasedDto.class);



	}
}
