package br.com.megadata.megareg.apiintegracaobancos.infra.gatewayImpl.client;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.megadata.megareg.apiintegracaobancos.core.exception.GatewayException;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.BancoDoBrasilClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankBilling;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.BillingDataBancoDoBrasilResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingBancoDoBrasilResponse;
import br.com.megadata.megareg.apiintegracaobancos.infra.rest.BancoDoBrasilClient;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Component
@AllArgsConstructor
public class BancoDoBrasilClientGatewayImpl implements BancoDoBrasilClientGateway {

	private final BancoDoBrasilClient bancoDoBrasilClient;

	public String getToken() {
		try {
            
            return bancoDoBrasilClient.getToken();
	        
        } catch (Exception e) {
        	throw new GatewayException("Get token", e);
        }
	}

	public Optional<BillingDataBancoDoBrasilResponse> submitBilling(@NonNull final String token, final IBankBilling dadosBancoTaxaContratoRequest){

		try {
            
            return bancoDoBrasilClient.submitBilling(token, dadosBancoTaxaContratoRequest);
            
        } catch (Exception e) {
        	throw new GatewayException("Submit billing", e);
        }
	}
	
	public Optional<ConsultBillingBancoDoBrasilResponse> consultBilling(@NonNull final String token, String id){
		try {
			
			return bancoDoBrasilClient.consultBilling(token, id);
					
        } catch (Exception e) {
            throw new GatewayException("Consult billing", e);
        }
	}
}
