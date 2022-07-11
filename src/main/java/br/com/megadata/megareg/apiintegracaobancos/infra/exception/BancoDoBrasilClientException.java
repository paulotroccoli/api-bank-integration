package br.com.megadata.megareg.apiintegracaobancos.infra.exception;

import br.com.megadata.megareg.apiintegracaobancos.core.exception.GatewayException;

public class BancoDoBrasilClientException extends GatewayException {

	private static final long serialVersionUID = -1387462195053674559L;

	private static final String ERROR = "gateway";

    private static final String MESSAGE = "%s gateway error";

	public BancoDoBrasilClientException() {
		super();
    }

    public BancoDoBrasilClientException(final String message, final Throwable throwable) {
    	super(String.format(MESSAGE, message), throwable);
    }
}
