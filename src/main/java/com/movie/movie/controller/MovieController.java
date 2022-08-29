package com.movie.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

	
	@GetMapping("/reserve")
	public String reserve(String movieCode) {
		return "movie/reserve";
	}
	
}
