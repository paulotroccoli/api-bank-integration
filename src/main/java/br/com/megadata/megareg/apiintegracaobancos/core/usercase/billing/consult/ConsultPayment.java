package br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.consult;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BillingData;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.repository.BillingDataGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response.ConsultBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.UpdateMegaRegBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.util.DateFormat;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConsultPayment {

	private final BillingDataGateway billingDataGateway;
	private final SubmitConsult sendConsultToBank;
	
	
	public void execute(){
			
//		final List<BillingData> billingDatas = billingDataGateway.getPendingBillingList();
//		
//		for (BillingData billingData : billingDatas) {
//			final ConsultBillingResponse consultBillingResponse = sendConsultToBank.execute(billingData);
//			
//			final UpdateMegaRegBillingResponse updateMegaRegBillingResponse = UpdateMegaRegBillingResponse.builder()
//					.codigoBarras(billingData.getBarCode())
//					.dataEnvio(new DateFormat(new Date()).toString("yyyyMMdd"))
//					.errors(consultBillingResponse.getError().stream().allMatch(error -> error == 0) ? "" : consultBillingResponse.getError().stream().map(Object::toString).collect(Collectors.joining(",")))
//					.build();
//			
//			billingDataGateway.updatePendingBilling(updateMegaRegBillingResponse);
//		}
	}
}
