package br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.submit;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BankData;
import br.com.megadata.megareg.apiintegracaobancos.core.domain.enums.Bank;
import br.com.megadata.megareg.apiintegracaobancos.core.exception.business.BankNotFoundException;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.repository.BankDataGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.request.BankDataRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.service.factory.BankingServiceFactory;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.request.billing.SubmitBillingRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmitBilling {

	private final BankingServiceFactory bankServiceFactory;
	private final BankDataGateway dadosBancoGateway;
	
	public SubmitBillingResponse execute(SubmitBillingRequest sendBillingToBankRequest){
		
		final BankData bankData = dadosBancoGateway.getActiveDataBank().orElseThrow(() -> new BankNotFoundException(""));
		
		final Bank bank = Bank.getByCode(bankData.getCodigoBanco());
		
		BankDataRequest bankDataRequest = BankDataRequest.builder()
						.codigoContrato(bankData.getCodigoContrato())
						.digitoVerificadorContaCorrenteDebito(bankData.getContaCorrenteDV())
						.lancamentos(Arrays.asList(sendBillingToBankRequest.toBarCodeDataRequest()))
						.numeroAgenciaDebito(bankData.getAgenciaNumero())
						.numeroContaCorrenteDebito(bankData.getContaCorrenteNumero())
						.numeroRequisicao(dadosBancoGateway.getNextNumber().longValue())
						.build();
		
		return bankServiceFactory.getBankService(bank).submitBilling(bankDataRequest);
	}
}
