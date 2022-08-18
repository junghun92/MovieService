package com.movie.api;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.movie.dto.MovieListReqDto;
import com.movie.movie.dto.MovieListResDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieApi {
	
	private final RestTemplate restTemplate;
	
	@Value("${movie-key}")
	private String movieKey;
	private String movieListUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?"
			+ "key={key}&targetDt={targetDt}&itemPerPage={itemPerPage}";

	/**
	 * 일별 박스오피스 리스트
	 */
	public MovieListResDto movieList() {	      
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String now = LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		return restTemplate.exchange(movieListUrl, HttpMethod.GET, entity, MovieListResDto.class, movieKey, now, "8").getBody();
	}

	/**
	 * 영화정보 크롤링
	 */
	public List<String> movieInfo(List<MovieListReqDto> movieListReqDto) {
		List<String> movieImage = new ArrayList<String>();
		Document doc = null;
		String naverMovieImgUrl = null;

		try {
			for(MovieListReqDto result : movieListReqDto) {
				naverMovieImgUrl = "https://movie.naver.com/movie/search/result.naver?query="+ result.getMovieNm() +"&section=all";
				doc = Jsoup.connect(naverMovieImgUrl).get();
				movieImage.add(doc.select(".result_thumb a img").first().attr("src").replace("?type=f67", ""));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return movieImage;
	}
}
