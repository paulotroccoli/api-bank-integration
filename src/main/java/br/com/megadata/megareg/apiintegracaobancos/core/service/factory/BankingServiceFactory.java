package br.com.megadata.megareg.apiintegracaobancos.core.service.factory;

import org.springframework.stereotype.Component;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.enums.Bank;
import br.com.megadata.megareg.apiintegracaobancos.core.exception.business.BankNotFoundException;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.BancoDoBrasilService;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.BancoSantanderService;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBank;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Component
@AllArgsConstructor
public class BankingServiceFactory {

	private final BancoDoBrasilService bancoDoBrasilService;
	private final BancoSantanderService bancoSantanderService;


	public IBank getBankService(@NonNull final Bank bank) throws BankNotFoundException {
		switch (bank) {
			case BB:
				return bancoDoBrasilService;
			case SANTANDER:
				return bancoSantanderService;
			default:
				throw new BankNotFoundException(bank.getDescription());

		}
	} 

}
