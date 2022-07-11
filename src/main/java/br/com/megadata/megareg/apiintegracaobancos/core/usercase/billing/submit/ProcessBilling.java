package br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.submit;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.MegaregClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.request.billing.SubmitBillingRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.BarCodeDataResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.UpdateMegaRegBillingResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.util.DateFormat;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProcessBilling {

	private final SubmitBilling submitBilling;
	private final MegaregClientGateway megaregClientGateway;
	
	public void execute(SubmitBillingRequest sendBillingToBankRequest){
			
		SubmitBillingResponse billingDataResponse = submitBilling.execute(sendBillingToBankRequest);
		
		for (BarCodeDataResponse barCodeDataResponse : billingDataResponse.getLancamentos()) {
			
			final UpdateMegaRegBillingResponse updateMegaRegBillingResponse = UpdateMegaRegBillingResponse.builder()
					.codigoBarras(barCodeDataResponse.getCodigoBarras())
					.dataEnvio(new DateFormat(new Date()).toString("yyyyMMdd"))
					.errors(barCodeDataResponse.getErrors().stream().allMatch(error -> error == 0) ? "" : barCodeDataResponse.getErrors().stream().map(Object::toString).collect(Collectors.joining(",")))
					.build();
	
			megaregClientGateway.updateMegaRegBilling(updateMegaRegBillingResponse);
		}
	}
}
