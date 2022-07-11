package br.com.megadata.megareg.apiintegracaobancos.infra.gatewayImpl.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BillingData;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.repository.BillingDataGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.UpdateMegaRegBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.infra.repository.billingdatastatus.BillingDataStatusRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BillingDataGatewayImpl implements BillingDataGateway{

	private final BillingDataStatusRepository billingDataStatusRepository; 

	@Override
	public List<BillingData> getPendingBillingList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePendingBilling(UpdateMegaRegBillingResponse updateMegaRegBillingResponse) {
		// TODO Auto-generated method stub
		
	}
	
}
