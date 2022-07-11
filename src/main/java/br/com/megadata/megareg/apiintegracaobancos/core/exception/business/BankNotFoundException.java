package br.com.megadata.megareg.apiintegracaobancos.core.exception.business;

public class BankNotFoundException extends BusinessException {

	private static final long serialVersionUID = 2023305727383793090L;

	private static final String ERROR = "bank_not_found";

    private static final String MESSAGE = "Bank %s not found";

    public BankNotFoundException(final String bank) {
        super(String.format(MESSAGE, bank), ERROR);
    }
}
