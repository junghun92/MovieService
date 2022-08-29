package com.movie.movie.service;

import java.util.List;

import com.movie.movie.dto.MovieListDto;
import com.movie.movie.dto.ReserveDateDto;
import com.movie.movie.dto.ReserveMovieDto;
import com.movie.movie.dto.ReserveScreenPlanDto;
import com.movie.movie.dto.ReserveTheaterDto;

public interface MovieService {
	
	/**
	 * 영화 리스트
	 */
	public MovieListDto movieList(Integer display);
	
	/**
	 * 영화관
	 */
	public List<ReserveTheaterDto> reserveTheater(String movieCode);
	
	/**
	 * 상영날짜
	 */
	public List<ReserveDateDto> reserveDate(String theaterCode);

	/**
	 * 상영영화
	 */
	public List<ReserveMovieDto> reserveMovie(String playDate, String movieCode, String theaterCode);

	/**
	 * 상영시간
	 */
	public boolean reserveScreenPlanSave();

	public List<ReserveScreenPlanDto> reserveScreenPlan(String playDate, String movieCode, String theaterCode);


}
