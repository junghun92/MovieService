package com.movie.movie.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.movie.api.MovieApi;
import com.movie.movie.dto.MovieDailyBoxOfficeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieService {

	private final MovieApi movieApi;
	
	public MovieDailyBoxOfficeDto boxOfficeList() {
		return movieApi.boxOfficeList();
	}
}
