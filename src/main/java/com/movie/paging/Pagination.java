package com.movie.paging;

import com.movie.common.SearchDto;

import lombok.Getter;

@Getter
public class Pagination {

	private int totalRecordCount;	//��ü ������ ��
	private int totalPageCount;		//��ü ������ ��
	private int startPage;			//ù ������ ��ȣ
	private int endPage;			//�� ������ ��ȣ
	private int limitStart;			//LIMIT ���� ��ġ
	private boolean existPrevPage;	//���� ������ ���� ����
	private boolean existNextPage;	//���� ������ ���� ����
	
	public Pagination(int totalRecordCount, SearchDto params) {
		if(totalRecordCount > 0) {
			this.totalRecordCount = totalRecordCount;
			this.calculation(params);
		}
	}
	
	public void calculation(SearchDto params) {
        // ��ü ������ �� ���
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) + 1;

        // ���� ������ ��ȣ�� ��ü ������ ������ ū ���, ���� ������ ��ȣ�� ��ü ������ �� ����
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // ù ������ ��ȣ ���
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // �� ������ ��ȣ ���
        endPage = startPage + params.getPageSize() - 1;

        // �� �������� ��ü ������ ������ ū ���, �� ������ ��ü ������ �� ����
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT ���� ��ġ ���
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        // ���� ������ ���� ���� Ȯ��
        existPrevPage = startPage != 1;

        // ���� ������ ���� ���� Ȯ��
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
	}
	
}
