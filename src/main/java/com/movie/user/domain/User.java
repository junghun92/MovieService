package com.movie.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 정보
 */
@Getter
@NoArgsConstructor
public class User {
	
	private String name;
	private String email;
	private Role role;
	
	@Builder
	public User(String name, String email,Role role) {
		this.name = name;
		this.email = email;
		this.role = role;
	}
	
	public User update(String name) {
		this.name = name;
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}

}
