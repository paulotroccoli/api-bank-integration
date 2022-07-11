package br.com.megadata.megareg.apiintegracaobancos.infra.exception;

import br.com.megadata.megareg.apiintegracaobancos.core.exception.GatewayException;

public class MegaregClientException extends GatewayException {

	private static final long serialVersionUID = -1387462195053674559L;

	private static final String ERROR = "gateway";

    private static final String MESSAGE = "%s gateway error";

	public MegaregClientException() {
		super();
    }

    public MegaregClientException(final String message, final Throwable throwable) {
    	super(String.format(MESSAGE, message), throwable);
    }
}
