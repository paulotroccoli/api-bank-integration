package br.com.megadata.megareg.apiintegracaobancos.core.exception;

public class GatewayException extends ApiBankIntergrationException {

	private static final long serialVersionUID = -770002359449761021L;

	private static final String ERROR = "gateway";

    private static final String MESSAGE = "%s gateway error";

	public GatewayException() {
		super(MESSAGE, ERROR);
    }

    public GatewayException(final String message, final Throwable throwable) {
    	super(String.format(MESSAGE, message), ERROR, throwable);
    }
}

