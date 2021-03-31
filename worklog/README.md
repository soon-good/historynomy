# WORKLOG



# 2021/03/30

몽고DB에 코스피 데이터 인서트 작업을 마쳤고 차트 로직을 연동했다. 

이번 주 내로 아직 더 해야 하는 일들의 목록은 아래와 같다.

- 차트 스타일을 조금 손을 봐야 한다.(조금 많이, 자주 하게될수도)
- 추가적인 데이터(정책금리-한국,미국, 환율) INSERT
- 시간 조건검색 기능 기획하기
- 웹플럭스 검토

오늘 까지 한 내용은 아래와 같다.

- 몽고DB, 코스피 데이터 연동, 차트 렌더링 로직 작성



# 2021/03/31

오늘까지 완료한 amchart 로직이다. highchart로 변경예정이다. ([참고할 Highchart 예제](https://www.highcharts.com/demo/stock/candlestick-and-volume))

![이미지](./img/2021-0331-LUNCH-TIME.png)



- 데이터 축이 amchart와 highchart는 서로 다르다. amchart를 사용할 경우 모든 데이터를 서버에서 병합해서 가져와야 한다는 단점이 있다.  
- highchart의 경우 데이터를 단건으로 따로 들고와서 js 단에서 병합해도 되고, 공통적인 고정 시간 축만 있다면 차트 안에서 시간축으로 인한 오류가 나지 않는다.



# 2021/04/01

DB 에서 가져오는 코스피 엔티티 객체의 구조에 대한 Dto 는 **KospiDto.java** 였는데, 이것을 PriceDto.java 로 매핑하는 공통 함수를 작성했다.

앞으로 아래의 지표들을 가져올 것이기에 단위 (원/퍼센트/인덱스)별로 필요한 Dto의 종류를 구분지어놓고 매핑한다면, 여러가지 Dto들이 산재하는 것으로 인한 혼란을 미연에 방지할 것이라는 생각에서다.

- 코스피, 코스피 시가총액 
- 코스닥, 코스닥 시가총액
- 정책금리 (KR)
- 정책금리 (US)
- 원/달러
- 위안/달러

아직은 개선해야 할 점들이 많다. 임시방편으로 만들어놓았기 때문이다. 논리적인 성격을 구분짓기 위해서는 코딩보다는 논리적으로 구분하는 능력이 필요하기 때문에, 앞으로 추가되는 요구사항들을 더 보아야 확정될 것 같다. 지금은 일단 enum 으로 선언한 MarketIndexType 에 지표성격별 Dto 생성 빌더를 통해 객체를 생성하는 Function 을 반환해주는 메서드를 선언해두었다.  

  

**KospServiceImpl.java**

```java
@Service
public class KospiServiceImpl implements KospiService{

	// ...

	@Override
	public List<PriceDto> findAll(){
		List<Kospi> all = kospiRepository.findAll();

		List<PriceDto> results = all.stream()
			.map(kospi -> {
				return (PriceDto) INDEX_TYPE.mapToDto().apply(kospi);
			})
			.collect(Collectors.toList());

		return results;
	}
}
```



**MarketIndexType.java**

```java
package io.historynomy.serviceapi.types;

import io.historynomy.serviceapi.marketindex.dto.PriceDto;
import io.historynomy.serviceapi.marketindex.kospi.mongo.Kospi;
import java.util.function.Function;

public enum MarketIndexType {
	KOSPI("KOSPI", 10000){
		@Override
		public Function<Kospi, PriceDto> mapToDto(){
			return t -> {
				return PriceDto.builder()
					.dataValue(t.getDataValue())
					.dataName(t.getDataName())
					.time(t.getTime())
					.build();
			};
		}
	},
	// ...
	EXCHANGE_RATE_YUAN_DOLLAR("EXCHANGE_RATE_YUAN_DOLLAR", 30002){
		...
	};

	public abstract <T,R> Function<T,R> mapToDto();

	private String indexTypeNm;

	private int indexTypeCd;

	MarketIndexType(String indexTypeNm, int indexTypeCd){
		this.indexTypeNm = indexTypeNm;
		this.indexTypeCd = indexTypeCd;
	}

}
```

