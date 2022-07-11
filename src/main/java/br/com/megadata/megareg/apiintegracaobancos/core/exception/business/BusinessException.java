package br.com.megadata.megareg.apiintegracaobancos.core.exception.business;

import br.com.megadata.megareg.apiintegracaobancos.core.exception.ApiBankIntergrationException;

public class BusinessException extends ApiBankIntergrationException {
    
	private static final long serialVersionUID = -9108536311730592908L;

	public BusinessException(final String message, final String error) {
        super(message, error);
    }
    
}
