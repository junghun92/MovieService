package com.movie.movie.dto;

import lombok.Data;

@Data
public class ReserveMovieDto {
	
	private String movieCode;		// ��ȭ�ڵ�
	private String movieNm;			// ��ȭ��
	private String movieAge;		// ��������
	private boolean disabledChk;		// �󿵿���
	
}
