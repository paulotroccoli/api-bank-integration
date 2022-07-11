package br.com.megadata.megareg.apiintegracaobancos.core.exception.business;

public class SubmitBillingException extends BusinessException {
    
	private static final long serialVersionUID = -2047468378195045589L;

	private static final String ERROR = "submit_billing";

    private static final String MESSAGE = "Error when submit billing to bank";

    public SubmitBillingException() {
        super(MESSAGE, ERROR);
    }
    
}
