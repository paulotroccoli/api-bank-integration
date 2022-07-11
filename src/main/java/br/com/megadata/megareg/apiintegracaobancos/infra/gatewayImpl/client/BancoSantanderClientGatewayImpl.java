package br.com.megadata.megareg.apiintegracaobancos.infra.gatewayImpl.client;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.BancoSantanderClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankBilling;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.BillingDataBancoSantanderResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingBancoSantanderResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BancoSantanderClientGatewayImpl implements BancoSantanderClientGateway {@Override
	
	
	public Optional<BillingDataBancoSantanderResponse> submitBilling(String token, IBankBilling dadosBancoTaxaContratoRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ConsultBillingBancoSantanderResponse> consultBilling(String token, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
