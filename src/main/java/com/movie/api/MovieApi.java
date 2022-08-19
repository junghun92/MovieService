package com.movie.api;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.movie.dto.MovieListResDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieApi {
	
	private final RestTemplate restTemplate;
	
	@Value("${movie-key}")
	private String movieKey;
	private String movieListUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?"
			+ "key={key}&targetDt={targetDt}&itemPerPage={itemPerPage}&weekGb={weekGb}";
								   
	/**
	 * 주간 박스오피스 리스트
	 */
	public MovieListResDto movieList() {	      
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String date = LocalDateTime.now().minusDays(7).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		return restTemplate.exchange(movieListUrl, HttpMethod.GET, entity, MovieListResDto.class, movieKey, date, "8", "0").getBody();
	}

	/**
	 * 영화정보 크롤링
	 */
	public List<String> movieImageList() {
		List<String> movieImageList = new ArrayList<String>();
		String date = LocalDateTime.now().minusDays(7).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String daumMovieUrl = "https://movie.daum.net/ranking/boxoffice/weekly?data="+date;
		
		try {
			Document doc = Jsoup.connect(daumMovieUrl).get();
			Elements elements = doc.select(".poster_movie");
			int index = 0;
			for(Element element : elements) {
				movieImageList.add(element.select("img").attr("src"));
				if(++index == 8) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return movieImageList;
	}
}
