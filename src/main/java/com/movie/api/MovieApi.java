package com.movie.api;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.movie.dto.MovieListDto;
import com.movie.movie.dto.ReserveDateDto;
import com.movie.movie.dto.ReserveMovieDto;
import com.movie.movie.dto.ReserveScreenPlanDto;
import com.movie.movie.dto.ReserveTheaterDto;
import com.movie.movie.dto.MovieListDto.Movie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieApi {
	
	private final RestTemplate restTemplate;
	
	/*
	@Value("${movie-key}")
	private String movieKey;
	private String movieListUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?"
			+ "key={key}&targetDt={targetDt}&itemPerPage={itemPerPage}&weekGb={weekGb}";
	*/
	

	private final String movieUrl = "https://www.cineq.co.kr/";										//영화 리스트 URL
	private final String reserveTheaterUrl = "https://www.cineq.co.kr/Popup/Reserve";				//영화관 URL
	private final String reserveDateUrl = "https://www.cineq.co.kr/popup/ReserveDateList";			//상영날짜 URL
	private final String reserveMovieUrl = "https://www.cineq.co.kr/popup/ReserveMovieList";		//상영영화 URL
	private final String reserveScreenPlanUrl = "https://www.cineq.co.kr/popup/ReserveScreenPlan";	//상영시간 URL
	
	/**
	 * 영화 리스트
	 */
	public MovieListDto movieList(Integer display) {
		MovieListDto movieList = new MovieListDto();
		
		try {
			Document doc = Jsoup.connect(movieUrl).get();
			Elements boxOffice = doc.select(".main-movie-list .bxslider-bo li");
			Elements latest = doc.select(".main-movie-list .bxslider-lr li");
			Elements comming = doc.select(".main-movie-list .bxslider-cs li");
			
			movieList.setBoxOfficeList(movieData(boxOffice, display));	//박스오피스
			movieList.setLatestList(movieData(latest, display));		//최신 개봉작
			movieList.setCommingList(movieData(comming, display));		//상영 예정작

		} catch (IOException e) {
			e.printStackTrace();
		}

		return movieList;
	}

	/**
	 * 영화 리스트 추출
	 */
	private List<Movie> movieData(Elements element, Integer display) {
		List<Movie> resultList = new ArrayList<>();
		int index = 0;
		
		for(Element result : element) {
			Movie movie = new Movie();
			movie.setMovieCode(result.attr("data-moviecode"));
			movie.setMovieAge(result.select(".movie-desc span").text().replace("이상", ""));
			result.select(".movie-desc span").remove();
			movie.setMovieNm(result.select(".movie-desc").text());
			movie.setMovieImage(result.select("img").attr("src"));
			
			resultList.add(movie);
			if(++index == display) {
				break;
			}
		}
		return resultList;
	}
	
	/**
	 * 영화관
	 */
	public List<ReserveTheaterDto> reserveTheater(String movieCode) {
		List<ReserveTheaterDto> resultList = new ArrayList<>();

		try {
			Document doc = Jsoup.connect(reserveTheaterUrl)
					.header("accept", "*/*")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko,en-US;q=0.9,en;q=0.8")
					.header("origin", "https://www.cineq.co.kr")
					.header("referer", "https://www.cineq.co.kr/")
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
					.data("movieCode", movieCode)
					.post();
			
			Elements elements = doc.select(".theater");
			
			for(Element element : elements) {
				ReserveTheaterDto reserveTheaterDto = new ReserveTheaterDto();
				reserveTheaterDto.setTheaterCode(element.attr("data-theatercode"));
				reserveTheaterDto.setTheater(element.text());
				
				resultList.add(reserveTheaterDto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * 상영날짜
	 */
	public List<ReserveDateDto> reserveDate(String theaterCode) {
		List<ReserveDateDto> resultList = new ArrayList<>();
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		try {
			Document doc = Jsoup.connect(reserveDateUrl)
					.header("accept", "*/*")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko,en-US;q=0.9,en;q=0.8")
					.header("origin", "https://www.cineq.co.kr")
					.header("referer", "https://www.cineq.co.kr/")
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
					.data("theaterCode", theaterCode)
					.data("selectDate", date)
					.data("viewDate", date)
					.post();
			
			Elements elements = doc.select(".datelist");
			
			for(Element element : elements) {
				ReserveDateDto reserveDateDto = new ReserveDateDto();
				reserveDateDto.setDate(element.select("a").attr("data-date"));
				reserveDateDto.setDay(element.select("a").html());
				
				resultList.add(reserveDateDto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

	/**
	 * 상영영화
	 */
	public List<ReserveMovieDto> reserveMovie(String playDate, String movieCode, String theaterCode) {
		List<ReserveMovieDto> resultList = new ArrayList<>();
		
		try {
			Document doc = Jsoup.connect(reserveMovieUrl)
					.header("accept", "*/*")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko,en-US;q=0.9,en;q=0.8")
					.header("origin", "https://www.cineq.co.kr")
					.header("referer", "https://www.cineq.co.kr/")
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
					.data("PlayDate", playDate)
					.data("movieCode", movieCode)
					.data("TheaterCode", theaterCode)
					.data("SortType", "1")
					.post();
			
			Elements elements = doc.select(".list-movie-name li");
			
			for(Element element : elements) {
				ReserveMovieDto reserveMovieDto = new ReserveMovieDto();
				reserveMovieDto.setMovieCode(element.select("input").val());
				reserveMovieDto.setMovieAge(element.select("label span").text());
				element.select("label span").remove();
				reserveMovieDto.setMovieNm(element.select("label").text());
				reserveMovieDto.setDisabledChk(element.select("input").hasAttr("disabled"));

				resultList.add(reserveMovieDto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}

								   
	/**
	 * 주간 박스오피스 리스트
	 */
	/*
	public MovieListResDto movieList() {	      
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String date = LocalDateTime.now().minusDays(7).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		return restTemplate.exchange(movieListUrl, HttpMethod.GET, entity, MovieListResDto.class, movieKey, date, "8", "0").getBody();
	}
	*/
}
