package br.com.megadata.megareg.apiintegracaobancos.core.service.bank;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.BancoDoBrasilClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BankDataRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BillingDataBancoDoBrasilRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class BancoDoBrasilService implements IBank {
	
	private final BancoDoBrasilClientGateway bancoDoBrasilClientGateway;
	
	@Override
	public SubmitBillingResponse submitBilling(@NonNull final BankDataRequest bankDataRequest){

		final IBankBilling iBankBilling = BillingDataBancoDoBrasilRequest.builder().build().converteBankData(bankDataRequest);
		
		final String token = bancoDoBrasilClientGateway.getToken();
		
		return bancoDoBrasilClientGateway.submitBilling(token, iBankBilling).map(barCode -> barCode.toDadosBancoTaxaContratoResponse()).get();
	}

	@Override
	public ConsultBillingResponse consultBilling(@NonNull final String id) {

		final String token = bancoDoBrasilClientGateway.getToken();
		
		return bancoDoBrasilClientGateway.consultBilling(token, id).map(consult -> consult.converteBankConsultData()).get();
	}

	

}
