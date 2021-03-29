package io.historynomy.serviceapi.kospi.tdd;

import io.historynomy.serviceapi.marketindex.kospi.KospiDto;
import io.historynomy.serviceapi.marketindex.kospi.KospiService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KospiServiceTest {

	@Autowired
	KospiService kospiService;

	@Test
	void 테스틈ㄴㅇㄹㅁㄴㅇㄹ(){
		List<KospiDto> all = kospiService.findAll();
		all.stream().forEach(kospiDto -> {
			System.out.println(kospiDto);
		});
	}

}
