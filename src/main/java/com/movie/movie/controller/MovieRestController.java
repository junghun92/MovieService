package com.movie.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.dto.MovieDailyBoxOfficeDto;
import com.movie.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieRestController {
	
	private final MovieService movieService;
	
	@GetMapping
	public MovieDailyBoxOfficeDto boxOfficeList() {
		return movieService.boxOfficeList();
	}
	
	
}
