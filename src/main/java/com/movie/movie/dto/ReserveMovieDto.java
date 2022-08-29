package com.movie.movie.dto;

import lombok.Data;

@Data
public class ReserveMovieDto {
	
	private String movieCode;		// 영화코드
	private String movieNm;			// 영화명
	private String movieAge;		// 관람나이
	private boolean disabledChk;		// 상영여부
	
}
