package br.com.megadata.megareg.apiintegracaobancos.infra.gatewayImpl.client;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.exception.GatewayException;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.MegaregClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.UpdateMegaRegBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.infra.rest.MegaregClient;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MegaregClientGatewayImpl implements MegaregClientGateway{
	
	private final MegaregClient megaregClient;
	
	@Override
	public void updateMegaRegBilling(UpdateMegaRegBillingResponse updateMegaRegBillingResponse) {

        try {
        	megaregClient.updateMegaRegBilling(updateMegaRegBillingResponse);

        } catch (Exception e) {
        	throw new GatewayException("Uodate Megareg billing", e);
        }
    }
}
