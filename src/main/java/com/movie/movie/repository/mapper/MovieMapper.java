package com.movie.movie.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.movie.movie.dto.ReserveScreenPlanDto;

@Mapper
public interface MovieMapper {

	void reserveScreenPlanSave(ReserveScreenPlanDto reserveScreenPlanDto);

	int reserveScreenPlanCount(ReserveScreenPlanDto reserveScreenPlanDto);

	List<ReserveScreenPlanDto> reserveScreenPlan(@Param("playDate") String playDate, @Param("movieCode") String movieCode, @Param("theaterCode") String theaterCode);

}
