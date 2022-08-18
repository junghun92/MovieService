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
	 * �Ϻ� �ڽ����ǽ�
	 */
	@GetMapping
	public MovieListResDto movieList() {
		return movieService.movieList();
	}
	
	/**
	 * ��ȭ���� ũ�Ѹ�
	 */
	@PostMapping("/info")
	public List<String> movieInfo(@RequestBody List<MovieListReqDto> movieListReqDto) {
		return movieService.movieInfo(movieListReqDto);
	}
	
	
	
}
