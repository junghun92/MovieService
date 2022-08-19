package com.movie.movie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.dto.MovieListResDto;
import com.movie.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieRestController {
	
	private final MovieService movieService;
	
	/**
	 * �ְ� �ڽ����ǽ�
	 */
	@GetMapping
	public MovieListResDto movieList() {
		return movieService.movieList();
	}
	
	/**
	 * ��ȭ���� ũ�Ѹ�
	 */
	@PostMapping("/imageList")
	public List<String> movieImageList() {
		return movieService.movieImageList();
	}
	
	
	
}
