package com.movie.community.repository;

import java.util.List;

import com.movie.common.SearchDto;
import com.movie.community.domain.Community;

public interface CommunityRepository {
	
	Community save(Community community);

	List<Community> findAll(SearchDto params);

	Community findById(long id);

	void update(long id, Community community);

	int count(SearchDto params);

}
