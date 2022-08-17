package com.movie.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.movie.dto.MovieDailyBoxOfficeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieApi {
	
	private final RestTemplate restTemplate;
	private final String key = "cff573fc6e6e3cd2d408b4d7094710c7";
	private final String searchDailyBoxOfficeListUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?"
			+ "key={key}&targetDt={targetDt}&itemPerPage={itemPerPage}";

	/**
	 * 일별 박스오피스 리스트
	 */
	public MovieDailyBoxOfficeDto boxOfficeList() {
	      HashMap<String, Object> result = new HashMap<String, Object>();
	      
	      final HttpHeaders headers = new HttpHeaders();
	      final HttpEntity<String> entity = new HttpEntity<>(headers);
	      String now = LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	      
	      return restTemplate.exchange(searchDailyBoxOfficeListUrl, HttpMethod.GET, entity, MovieDailyBoxOfficeDto.class, key, now, "8").getBody();
	}
}
