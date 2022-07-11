package br.com.megadata.megareg.apiintegracaobancos.core.gateway.repository;

import java.util.List;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BillingData;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.UpdateMegaRegBillingResponse;

public interface BillingDataGateway {

	List<BillingData> getPendingBillingList();
	void updatePendingBilling(UpdateMegaRegBillingResponse updateMegaRegBillingResponse);
}
