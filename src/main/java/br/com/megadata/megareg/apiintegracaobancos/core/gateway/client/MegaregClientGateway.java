package br.com.megadata.megareg.apiintegracaobancos.core.gateway.client;

import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.UpdateMegaRegBillingResponse;

public interface MegaregClientGateway {

	void updateMegaRegBilling(UpdateMegaRegBillingResponse updateMegaRegBillingResponse);
}
