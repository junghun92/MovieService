package com.movie.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.api.MovieApi;
import com.movie.movie.dto.MovieListResDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieService {

	private final MovieApi movieApi;
	
	public MovieListResDto movieList() {
		return movieApi.movieList();
	}

	public List<String> movieImageList() {
		return movieApi.movieImageList();
	}
}
