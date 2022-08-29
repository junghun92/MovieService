package com.movie.community.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.common.SearchDto;
import com.movie.community.domain.Community;
import com.movie.community.repository.CommunityRepository;
import com.movie.paging.Pagination;
import com.movie.paging.PagingResponse;

import lombok.RequiredArgsConstructor;


public interface CommunityService{
	
	public Community save(Community community);

	public PagingResponse<Community> findAll(SearchDto params) ;

	public Community findById(long id);

	public void update(long id, Community community);

}
