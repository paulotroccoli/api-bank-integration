package br.com.megadata.megareg.apiintegracaobancos.core.exception.business;

public class ConsultBillingException extends BusinessException{
    
	private static final long serialVersionUID = -1665859141440519167L;

	private static final String ERROR = "consult_billing";

    private static final String MESSAGE = "Error when consult billing from bank";

    public ConsultBillingException() {
        super(MESSAGE, ERROR);
    }
    
}
