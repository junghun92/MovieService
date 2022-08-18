package com.movie.movie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.dto.MovieListReqDto;
import com.movie.movie.dto.MovieListResDto;
import com.movie.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieRestController {
	
	private final MovieService movieService;
	
	/**
	 * 일별 박스오피스
	 */
	@GetMapping
	public MovieListResDto movieList() {
		return movieService.movieList();
	}
	
	/**
	 * 영화정보 크롤링
	 */
	@PostMapping("/info")
	public List<String> movieInfo(@RequestBody List<MovieListReqDto> movieListReqDto) {
		return movieService.movieInfo(movieListReqDto);
	}
	
	
	
}
