package com.movie.movie.dto;

import lombok.Data;

@Data
public class ReserveScreenPlanDto {
	
	private String id;			//시퀀스
	private String theaterCode;	//영화관 코드
	private String movieCode;	//영화 코드
	private String seatCnt;		//좌석수
	private String playDate;	//상영날짜
	private String startTime;	//시작시간
	private String endTime;		//종료시간
	private String reg_date;	//등록일
	
}
