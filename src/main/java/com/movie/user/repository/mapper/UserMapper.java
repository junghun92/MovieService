package com.movie.user.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.movie.user.domain.User;

@Mapper
public interface UserMapper {
	
	User findByEmail(String email);
	
	void save(User user);

}
