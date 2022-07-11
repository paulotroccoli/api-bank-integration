package br.com.megadata.megareg.apiintegracaobancos.core.service.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.megadata.megareg.apiintegracaobancos.core.domain.enums.Bank;
import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.MegaregClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.BancoDoBrasilService;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.BancoSantanderService;
import br.com.megadata.megareg.apiintegracaobancos.core.service.bank.IBank;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.submit.ProcessBilling;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.submit.SubmitBilling;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.request.billing.SubmitBillingRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.BarCodeDataResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BankServiceFactoryTest {

	@Mock
	private BancoDoBrasilService bancoDoBrasilService;
	@Mock
	private BancoSantanderService bancoSantanderService;
	
	private BankingServiceFactory bankingServiceFactory;
	
	@BeforeEach
	public void setup() {
		bankingServiceFactory = new BankingServiceFactory(bancoDoBrasilService, bancoSantanderService);
	}
	
	@Test
	public void bankServiceFactgoryBB() {
		
		IBank ibank = bankingServiceFactory.getBankService(Bank.BB);
		assertEquals(ibank, bancoDoBrasilService);
//		verify(processBilling, times(1)).execute(sendBillingToBankRequest);
	}
	
	@Test
	public void bankServiceFactgoryBradesco() {
		
		IBank ibank = bankingServiceFactory.getBankService(Bank.SANTANDER);
		assertEquals(ibank, bancoSantanderService);
//		verify(processBilling, times(1)).execute(sendBillingToBankRequest);
	}
}
