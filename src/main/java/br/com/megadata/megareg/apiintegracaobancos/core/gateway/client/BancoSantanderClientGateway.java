package br.com.megadata.megareg.apiintegracaobancos.core.gateway.client;

import java.util.Optional;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankBilling;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.BillingDataBancoSantanderResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingBancoSantanderResponse;

public interface BancoSantanderClientGateway {

	Optional<BillingDataBancoSantanderResponse> submitBilling(String token, IBankBilling dadosBancoTaxaContratoRequest);
	String getToken();
	Optional<ConsultBillingBancoSantanderResponse> consultBilling(String token, String id);
}
