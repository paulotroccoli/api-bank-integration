package br.com.megadata.megareg.apiintegracaobancos.core.service.bank;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BankDataRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;

/** 
* @author Edson Cicero
* @since 19/04/2022
*/

public interface IBank {
	SubmitBillingResponse submitBilling(BankDataRequest bankDataRequest);
	ConsultBillingResponse consultBilling(String id);
}
