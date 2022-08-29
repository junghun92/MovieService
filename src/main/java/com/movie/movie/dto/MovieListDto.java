package com.movie.movie.dto;

import java.util.List;

import lombok.Data;

@Data
public class MovieListDto {
	private List<Movie> boxOfficeList;		// 박스오피스
	private List<Movie> latestList;			// 최신개봉작
	private List<Movie> commingList;		// 상영예정작
	
	@Data
	public static class Movie{
		private String movieCode;		// 영화코드
		private String movieNm;			// 영화명
		private String movieImage;		// 포스터
		private String movieAge;		// 관람나이
	}
	
	
}
