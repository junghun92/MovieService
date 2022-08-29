package com.movie.movie.dto;

import java.util.List;

import lombok.Data;

@Data
public class MovieListDto {
	private List<Movie> boxOfficeList;		// �ڽ����ǽ�
	private List<Movie> latestList;			// �ֽŰ�����
	private List<Movie> commingList;		// �󿵿�����
	
	@Data
	public static class Movie{
		private String movieCode;		// ��ȭ�ڵ�
		private String movieNm;			// ��ȭ��
		private String movieImage;		// ������
		private String movieAge;		// ��������
	}
	
	
}
