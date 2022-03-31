package com.spe.backend.dto.response;

import com.spe.backend.model.User;

public class SignInResponseDto {
	
	private String status;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SignInResponseDto(String status, User user) {
		super();
		this.status = status;
		this.user = user;
	}

	public SignInResponseDto() {
		super();
	}

}
