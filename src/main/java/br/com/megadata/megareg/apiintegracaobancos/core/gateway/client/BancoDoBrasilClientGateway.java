package br.com.megadata.megareg.apiintegracaobancos.core.gateway.client;

import java.util.Optional;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankBilling;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.BillingDataBancoDoBrasilResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingBancoDoBrasilResponse;

public interface BancoDoBrasilClientGateway {

	Optional<BillingDataBancoDoBrasilResponse> submitBilling(String token, IBankBilling dadosBancoTaxaContratoRequest);
	String getToken();
	Optional<ConsultBillingBancoDoBrasilResponse> consultBilling(String token, String id);
}
