package br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBankBilling;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingDataBancoSantanderRequest implements IBankBilling{@Override
	public IBankBilling converteBankData(BankDataRequest bankDataRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
