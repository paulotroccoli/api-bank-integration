package br.com.megadata.megareg.apiintegracaobancos.core.exception;

import lombok.Getter;

@Getter
public class ApiBankIntergrationException extends RuntimeException {

	private static final long serialVersionUID = -9035600558239613466L;
	
	private final String error;

    public ApiBankIntergrationException(final String message, final String error) {
        super(message);
        this.error = error;
    }

    public ApiBankIntergrationException(final String message, final String error, final Throwable throwable) {
        super(message, throwable);
        this.error = error;
    }

}

