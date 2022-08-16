package com.movie.config.auth;

import java.io.Serializable;

import com.movie.user.domain.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable{
	private String name, email, picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
