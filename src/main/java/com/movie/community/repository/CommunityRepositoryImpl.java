package com.movie.community.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.movie.common.SearchDto;
import com.movie.community.domain.Community;
import com.movie.community.repository.mapper.CommunityMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommunityRepositoryImpl implements CommunityRepository{
	
	private final CommunityMapper communityMapper;
	
	@Override
	public Community save(Community community) {
		communityMapper.save(community);
		return community;
	}

	@Override
	public List<Community> findAll(SearchDto params) {
		return communityMapper.findAll(params);
	}

	@Override
	public Community findById(long id) {
		return communityMapper.findById(id);
	}

	@Override
	public void update(long id, Community community) {
		communityMapper.update(id, community);
	}

	@Override
	public int count(SearchDto params) {
		return communityMapper.count(params);
	}
}
