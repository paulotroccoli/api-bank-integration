package br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.consult;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BillingData;
import br.com.megadata.megareg.apiintegracaobancos.core.domain.enums.Bank;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.service.factory.BankingServiceFactory;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmitConsult {

	private final BankingServiceFactory bankServiceFactory;
	
	public ConsultBillingResponse execute(BillingData billingData){
		
		Bank bank = Bank.getByCode(billingData.getBankCode());
		
		return bankServiceFactory.getBankService(bank).consultBilling(billingData.getBarCode());
			
	}

}
