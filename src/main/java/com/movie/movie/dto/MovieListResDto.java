package com.movie.movie.dto;

import lombok.Data;

@Data
public class MovieListResDto {
	private boxOfficeResult boxOfficeResult;
	
	@Data
	static class boxOfficeResult{
		private String boxofficeType;	// �ڽ����ǽ� ������ ����մϴ�.
		private String showRange;		// �ڽ����ǽ� ��ȸ ���ڸ� ����մϴ�.
		private Movie[] dailyBoxOfficeList;
	}
	
	@Data
	static class Movie{
		private String rnum;			// ������ ����մϴ�.
		private String rank;			// �ش������� �ڽ����ǽ� ������ ����մϴ�.
		private String rankInten;		// ���ϴ�� ������ �������� ����մϴ�.
		private String rankOldAndNew;	// ��ŷ�� �ű����Կ��θ� ����մϴ�. ��OLD�� : ���� , ��NEW�� : �ű�
		private String movieCd;			// ��ȭ�� ��ǥ�ڵ带 ����մϴ�.
		private String movieNm;			// ��ȭ��(����)�� ����մϴ�.
		private String openDt;			// ��ȭ�� �������� ����մϴ�.
		private String salesAmt;		// �ش����� ������� ����մϴ�.
		private String salesShare;		// �ش����� ������ �����Ѿ� ��� �ش� ��ȭ�� ��������� ����մϴ�.
		private String salesInten;		// ���� ��� ����� �������� ����մϴ�.
		private String salesChange;		// ���� ��� ����� ���� ������ ����մϴ�.
		private String salesAcc;		// ����������� ����մϴ�.
		private String audiCnt;			// �ش����� �������� ����մϴ�.
		private String audiInten;		// ���� ��� ������ �������� ����մϴ�.
		private String audiChange;		// ���� ��� ������ ���� ������ ����մϴ�.
		private String audiAcc;			// ������������ ����մϴ�.
		private String scrnCnt;			// �ش����ڿ� ���� ��ũ������ ����մϴ�.
		private String showCnt;			// �ش����ڿ� �󿵵� Ƚ���� ����մϴ�.
	}
}
