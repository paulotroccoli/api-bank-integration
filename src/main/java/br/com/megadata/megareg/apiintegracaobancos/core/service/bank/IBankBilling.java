package br.com.megadata.megareg.apiintegracaobancos.core.service.bank;

import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BankDataRequest;

public interface IBankBilling {

	IBankBilling converteBankData(BankDataRequest bankDataRequest);
}
