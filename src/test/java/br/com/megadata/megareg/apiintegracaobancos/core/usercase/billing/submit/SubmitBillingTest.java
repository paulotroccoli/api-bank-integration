package br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.submit;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.BankData;
import br.com.megadata.megareg.apiintegracaobancos.core.domain.enums.Bank;
import br.com.megadata.megareg.apiintegracaobancos.core.exception.business.BankNotFoundException;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.MegaregClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.repository.BankDataGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.BancoDoBrasilService;
import br.com.megadata.megareg.apiintegracaobancos.core.service.factory.BankingServiceFactory;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.request.billing.SubmitBillingRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.BarCodeDataResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SubmitBillingTest {

	@Mock
	private BankingServiceFactory bankServiceFactory ;
	@Mock
	private BankDataGateway dadosBancoGateway;
	@Mock
	private BancoDoBrasilService bancoDoBrasilService;
	
	private SubmitBilling submitBilling;
	
	@BeforeEach
	public void setup() {
		submitBilling = new SubmitBilling(bankServiceFactory, dadosBancoGateway);
	}
	
	@Test
	public void submitBillingBancoDoBrasil() {
		
		SubmitBillingRequest sendBillingToBankRequest = SubmitBillingRequest.builder()
				.codigoBarras("83690000001057200052858120735518020735512003")
				.codigoSeuDocumento("2")
				.dataPagamento(20220711)
				.descricaoPagamento("")
				.numeroDocumentoDebito(2L)
				.valorPagamento(new BigDecimal("100"))
				.build();
		
		
		BankData bankData = BankData.builder()
				.agenciaDV(null)
				.agenciaNumero(null)
				.codigoBanco(33)
				.codigoContrato(null)
				.contaCorrenteDV(null)
				.contaCorrenteNumero(null)
				.operacional(null)
				.build();
				
		BigInteger proximoNumero = new BigInteger("12");
		
		when(dadosBancoGateway.getActiveDataBank()).thenReturn(Optional.of(bankData));
		when(dadosBancoGateway.getNextNumber()).thenReturn(proximoNumero);
		when(bankServiceFactory.getBankService(Bank.SANTANDER)).thenReturn(bancoDoBrasilService);
		submitBilling.execute(sendBillingToBankRequest);
//		verify(processBilling, times(1)).execute(sendBillingToBankRequest);
	}
	
	@Test
	@Ignore
	public void submitBillingError() {
		
//		SubmitBillingRequest sendBillingToBankRequest = SubmitBillingRequest.builder()
//				.codigoBarras("83690000001057200052858120735518020735512003")
//				.codigoSeuDocumento("2")
//				.dataPagamento(20220711)
//				.descricaoPagamento("")
//				.numeroDocumentoDebito(2L)
//				.valorPagamento(new BigDecimal("100"))
//				.build();
//		
//		
//		when(dadosBancoGateway.getActiveDataBank()).thenThrow(new BankNotFoundException(""));
//		verify(dadosBancoGateway).getActiveDataBank();
//		submitBilling.execute(sendBillingToBankRequest);
	}
}
