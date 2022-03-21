package com.spe.backend.dto.response;

public class SignInResponseDto {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SignInResponseDto(String status) {
		super();
		this.status = status;
	}

	public SignInResponseDto() {
		super();
	}

}
