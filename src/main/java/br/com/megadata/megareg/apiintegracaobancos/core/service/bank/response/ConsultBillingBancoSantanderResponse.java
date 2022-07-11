package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.response;

import java.util.List;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankConsultBilling;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsultBillingBancoSantanderResponse implements IBankConsultBilling {

	private List<PaymentBancoDoBrasilResponse> pagamentos;

	@Override
	public ConsultBillingResponse converteBankConsultData() {
		// TODO Auto-generated method stub
		return null;
	}
}
