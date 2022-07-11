package br.com.megadata.megareg.apiintegracaobancos.core.gateway.repository;

import java.math.BigInteger;
import java.util.Optional;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BankData;

public interface BankDataGateway {

	Optional<BankData> getActiveDataBank();
	BigInteger getNextNumber();
}
