package com.movie.movie.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.movie.movie.dto.ReserveScreenPlanDto;
import com.movie.movie.repository.mapper.MovieMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository{
	
	private final MovieMapper movieMapper;

	@Override
	public void reserveScreenPlanSave(ReserveScreenPlanDto reserveScreenPlanDto) {
		movieMapper.reserveScreenPlanSave(reserveScreenPlanDto);
	}

	@Override
	public int reserveScreenPlanCount(ReserveScreenPlanDto reserveScreenPlanDto) {
		return movieMapper.reserveScreenPlanCount(reserveScreenPlanDto);
	}

	@Override
	public List<ReserveScreenPlanDto> reserveScreenPlan(String playDate, String movieCode, String theaterCode) {
		return movieMapper.reserveScreenPlan(playDate, movieCode, theaterCode);
	}

}
