package br.com.megadata.megareg.apiintegracaobancos.core.service.bank;

/** realizar as tarefas oferecidas pelo BB
* @author Edson Cicero
* @since 16/04/2022
*/

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.BancoSantanderClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BankDataRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BillingDataBancoSantanderRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BancoSantanderService implements IBank {
	
	private final BancoSantanderClientGateway bancoSantanderClientGateway;
	
	@Override
	public SubmitBillingResponse submitBilling(BankDataRequest bankDataRequest){

		final IBankBilling iBankBilling = BillingDataBancoSantanderRequest.builder().build().converteBankData(bankDataRequest);
		
		final String token = bancoSantanderClientGateway.getToken();
		
		return bancoSantanderClientGateway.submitBilling(token, iBankBilling).map(barCode -> barCode.toDadosBancoTaxaContratoResponse()).get();
			
	}

	@Override
	public ConsultBillingResponse consultBilling(String id){

		final String token = bancoSantanderClientGateway.getToken();
		
		return bancoSantanderClientGateway.consultBilling(token, id).map(consult -> consult.converteBankConsultData()).get();
	}


}
