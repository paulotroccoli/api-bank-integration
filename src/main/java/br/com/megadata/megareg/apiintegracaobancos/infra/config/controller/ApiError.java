package br.com.megadata.megareg.apiintegracaobancos.infra.config.controller;

import lombok.Getter;

@Getter
public class ApiError {

	private final String error;
    private final String message; 
    private final String status;
    
	public ApiError(String error, String message, String status) {
		this.error = error;
		this.message = message;
		this.status = status;
	}
}
