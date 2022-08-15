package com.movie.common;

import com.movie.paging.Pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {
	
	private int page;					//���� ������ ��ȣ
	private int recordSize;				//�������� ����� ������ ����
	private int pageSize;				//ȭ�� �ϴܿ� ����� ������ ������
	private String keyword;				//�˻� Ű����
	private String searchType;			//�˻� ����
	private Pagination pagination;		//���������̼� ����
	
	public SearchDto() {
		this.page = 1;
		this.recordSize = 10;
		this.pageSize = 10;
	}
	
}
