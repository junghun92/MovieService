package com.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.movie.community.repository.CommunityRepository;
import com.movie.community.repository.CommunityRepositoryImpl;
import com.movie.community.repository.mapper.CommunityMapper;
import com.movie.community.service.CommunityService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

	private final CommunityMapper communityMapper;
	
/*	@Bean
	public CommunityRepository communityRepository() {
		return new CommunityRepositoryImpl(communityMapper);
	}
	*/
}
