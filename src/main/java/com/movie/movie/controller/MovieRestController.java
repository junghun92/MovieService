package com.movie.movie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.dto.MovieListDto;
import com.movie.movie.dto.ReserveDateDto;
import com.movie.movie.dto.ReserveMovieDto;
import com.movie.movie.dto.ReserveScreenPlanDto;
import com.movie.movie.dto.ReserveTheaterDto;
import com.movie.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieRestController {
	
	private final MovieService movieService;
	
	/**
	 * ��ȭ ����Ʈ
	 */
	@PostMapping(value="/list")
	public MovieListDto movieList(Integer display) {
		return movieService.movieList(display);
	}
	
	/**
	 * ��ȭ��
	 */
	@PostMapping(value="/reserveTheater")
	public List<ReserveTheaterDto> reserveTheater(String movieCode) {
		return movieService.reserveTheater(movieCode);
	}
	
	/**
	 * �󿵳�¥
	 */
	@PostMapping(value="/reserveDate")
	public List<ReserveDateDto> reserveDate(String theaterCode) {
		return movieService.reserveDate(theaterCode);
	}
	
	/**
	 * �󿵿�ȭ
	 */
	@PostMapping(value="/reserveMovie")
	public List<ReserveMovieDto> reserveMovie(String playDate, String movieCode, String theaterCode) {
		return movieService.reserveMovie(playDate, movieCode, theaterCode);
	}
	
	/**
	 * �󿵽ð� ������ ��ȸ
	 */
	@PostMapping(value="/reserveScreenPlan")
	public List<ReserveScreenPlanDto> reserveScreenPlan(String playDate, String movieCode, String theaterCode) {
		return movieService.reserveScreenPlan(playDate, movieCode, theaterCode);
	}
	
	/**
	 * �󿵽ð� ������ ����
	 */
	@GetMapping(value="/reserveScreenPlanSave")
	public boolean reserveScreenPlanSave() {
		return movieService.reserveScreenPlanSave();
	}
	
	
	
	
}
