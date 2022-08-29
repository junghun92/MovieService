package com.movie.community.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.common.SearchDto;
import com.movie.community.domain.Community;
import com.movie.community.repository.CommunityRepository;
import com.movie.paging.Pagination;
import com.movie.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService{
	
	private final CommunityRepository communityRepository;
	
	@Override
	public Community save(Community community) {
		return communityRepository.save(community);
	}

	@Override
	public PagingResponse<Community> findAll(SearchDto params) {
		int count = communityRepository.count(params);
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);
		
		List<Community> list = communityRepository.findAll(params);
		return new PagingResponse<>(list, pagination);
	}

	@Override
	public Community findById(long id) {
		return communityRepository.findById(id);
	}

	@Override
	public void update(long id, Community community) {
		communityRepository.update(id, community);
	}

}
