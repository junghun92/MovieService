package com.movie.movie.service;

import java.util.List;

import com.movie.movie.dto.MovieListDto;
import com.movie.movie.dto.ReserveDateDto;
import com.movie.movie.dto.ReserveMovieDto;
import com.movie.movie.dto.ReserveScreenPlanDto;
import com.movie.movie.dto.ReserveTheaterDto;

public interface MovieService {
	
	/**
	 * ��ȭ ����Ʈ
	 */
	public MovieListDto movieList(Integer display);
	
	/**
	 * ��ȭ��
	 */
	public List<ReserveTheaterDto> reserveTheater(String movieCode);
	
	/**
	 * �󿵳�¥
	 */
	public List<ReserveDateDto> reserveDate(String theaterCode);

	/**
	 * �󿵿�ȭ
	 */
	public List<ReserveMovieDto> reserveMovie(String playDate, String movieCode, String theaterCode);

	/**
	 * �󿵽ð�
	 */
	public boolean reserveScreenPlanSave();

	public List<ReserveScreenPlanDto> reserveScreenPlan(String playDate, String movieCode, String theaterCode);


}
