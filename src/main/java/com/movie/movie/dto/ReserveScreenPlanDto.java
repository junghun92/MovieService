package com.movie.movie.dto;

import lombok.Data;

@Data
public class ReserveScreenPlanDto {
	
	private String id;			//������
	private String theaterCode;	//��ȭ�� �ڵ�
	private String movieCode;	//��ȭ �ڵ�
	private String seatCnt;		//�¼���
	private String playDate;	//�󿵳�¥
	private String startTime;	//���۽ð�
	private String endTime;		//����ð�
	private String reg_date;	//�����
	
}
