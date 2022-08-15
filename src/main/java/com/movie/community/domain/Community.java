package com.movie.community.domain;

import lombok.Data;

@Data
public class Community {
	
	private Long id;
	
	private Integer userId;
	private String title;
	private String content;
	private String regDate;
	private String editDate;
	
	public Community() {
		
	}
	
	public Community(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	
}
