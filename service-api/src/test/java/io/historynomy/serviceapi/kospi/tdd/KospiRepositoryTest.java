package io.historynomy.serviceapi.kospi.tdd;

import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import io.historynomy.serviceapi.marketindex.kospi.mongo.KospiRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KospiRepositoryTest {

	@Autowired
	private KospiRepository kospiRepository;

//	@Test
//	void 테스틈ㄴㅇㄹㅁㄴㅇㄹ(){
//		System.out.println("####### ####### #######");
//		kospiRepository.findAll();
//		System.out.println("####### ####### #######");
//		all.subscribe(s -> System.out.println(s));
//		System.out.println("####### ####### #######");
//	}

	@Test
	void 테스트_findAll(){
		System.out.println("####### ####### #######");
		List<Kospi> all = kospiRepository.findAll();
		all.stream().forEach(kospi -> System.out.println(kospi));
	}
}
