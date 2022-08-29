package com.movie.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.api.MovieApi;
import com.movie.movie.dto.MovieListDto;
import com.movie.movie.dto.ReserveDateDto;
import com.movie.movie.dto.ReserveMovieDto;
import com.movie.movie.dto.ReserveScreenPlanDto;
import com.movie.movie.dto.ReserveTheaterDto;
import com.movie.movie.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService{

	private final MovieApi movieApi;
	private final MovieRepository movieRepository;
	
	/**
	 * 영화 리스트
	 */
	@Override
	public MovieListDto movieList(Integer display) {
		return movieApi.movieList(display);
	}
	
	/**
	 * 영화관
	 */
	@Override
	public List<ReserveTheaterDto> reserveTheater(String movieCode) {
		return movieApi.reserveTheater(movieCode);
	}
	
	/**
	 * 상영날짜
	 */
	@Override
	public List<ReserveDateDto> reserveDate(String theaterCode) {
		return movieApi.reserveDate(theaterCode);
	}

	/**
	 * 상영영화
	 */
	@Override
	public List<ReserveMovieDto> reserveMovie(String playDate, String movieCode, String theaterCode) {
		return movieApi.reserveMovie(playDate, movieCode, theaterCode);
	}

	/**
	 * 상영시간
	 */
	@Override
	public boolean reserveScreenPlanSave() {
		boolean status = true;
		
		String startTimeArr[] = {"13:40", "15:55", "19:00", "21:40"};
		String endTimeArr[] = {"15:55", "18:35", "21:15", "23:55"};
		
		List<ReserveTheaterDto> reserveTheater = reserveTheater("");	//영화관
		
		
		for(ReserveTheaterDto theater : reserveTheater) {
			List<ReserveDateDto> reserveDate = reserveDate(theater.getTheaterCode());	//상영날짜
			for(ReserveDateDto date : reserveDate) {
				List<ReserveMovieDto> reserveMovie = reserveMovie(date.getDate(), "", theater.getTheaterCode());	//영화 리스트
				for(ReserveMovieDto movie : reserveMovie) {
					for(int i=0; i<startTimeArr.length; i++) {
						ReserveScreenPlanDto reserveScreenPlanDto = new ReserveScreenPlanDto();
						
						reserveScreenPlanDto.setTheaterCode(theater.getTheaterCode());
						reserveScreenPlanDto.setMovieCode(movie.getMovieCode());
						reserveScreenPlanDto.setSeatCnt("48");
						reserveScreenPlanDto.setPlayDate(date.getDate());
						reserveScreenPlanDto.setStartTime(startTimeArr[i]);
						reserveScreenPlanDto.setEndTime(endTimeArr[i]);

						if(movieRepository.reserveScreenPlanCount(reserveScreenPlanDto) == 0) {
							movieRepository.reserveScreenPlanSave(reserveScreenPlanDto);
						}
					}
				}
			}
		}
		
		return status;
	}

	@Override
	public List<ReserveScreenPlanDto> reserveScreenPlan(String playDate, String movieCode, String theaterCode) {
		return movieRepository.reserveScreenPlan(playDate, movieCode, theaterCode);
	}

}
