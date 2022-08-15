package com.movie.community.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.movie.common.SearchDto;
import com.movie.community.domain.Community;

@Mapper
public interface CommunityMapper {
	
	void save(Community community);

	List<Community> findAll(SearchDto params);

	Community findById(long id);

	void update(@Param("id") long id, @Param("community") Community community);

	int count(SearchDto params);

}
