package com.movie.movie.repository;

import java.util.List;

import com.movie.movie.dto.ReserveScreenPlanDto;

public interface MovieRepository {

	void reserveScreenPlanSave(ReserveScreenPlanDto reserveScreenPlanDto);

	int reserveScreenPlanCount(ReserveScreenPlanDto reserveScreenPlanDto);

	List<ReserveScreenPlanDto> reserveScreenPlan(String playDate, String movieCode, String theaterCode);

}
