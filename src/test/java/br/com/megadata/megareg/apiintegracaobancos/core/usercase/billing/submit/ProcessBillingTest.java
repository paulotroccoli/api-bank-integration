package br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.submit;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.megadata.megareg.apiintegracaobancos.core.gateway.client.MegaregClientGateway;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.request.billing.SubmitBillingRequest;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.BarCodeDataResponse;
import br.com.megadata.megareg.apiintegracaobancos.core.usercase.response.billing.SubmitBillingResponse;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProcessBillingTest {

	@Mock
	private SubmitBilling submitBilling ;
	@Mock
	private MegaregClientGateway megaregClientGateway;
	
	private ProcessBilling processBilling;
	
	@BeforeEach
	public void setup() {
		processBilling = new ProcessBilling(submitBilling, megaregClientGateway);
	}
	
	@Test
	public void processBillingSuccessTest() {
		
		SubmitBillingRequest sendBillingToBankRequest = SubmitBillingRequest.builder()
				.codigoBarras("83690000001057200052858120735518020735512003")
				.codigoSeuDocumento("2")
				.dataPagamento(20220711)
				.descricaoPagamento("")
				.numeroDocumentoDebito(2L)
				.valorPagamento(new BigDecimal("100"))
				.build();
		
		
		BarCodeDataResponse barCodeDataResponse = BarCodeDataResponse.builder()
				.errors(Arrays.asList(0, 0, 0, 0, 0, 0, 0))
				.build();
		
		SubmitBillingResponse billingDataResponse = SubmitBillingResponse.builder()
				.lancamentos(Arrays.asList(barCodeDataResponse))
				.build();
				
		
		when(submitBilling.execute(sendBillingToBankRequest)).thenReturn(billingDataResponse);
		processBilling.execute(sendBillingToBankRequest);
//		verify(processBilling, times(1)).execute(sendBillingToBankRequest);
	}
	
	
	@Test
	public void processBillingErrorTest() {
		
		SubmitBillingRequest sendBillingToBankRequest = SubmitBillingRequest.builder()
				.codigoBarras("83690000001057200052858120735518020735512003")
				.codigoSeuDocumento("2")
				.dataPagamento(20220711)
				.descricaoPagamento("")
				.numeroDocumentoDebito(2L)
				.valorPagamento(new BigDecimal("100"))
				.build();
		
		
		BarCodeDataResponse barCodeDataResponse = BarCodeDataResponse.builder()
				.errors(Arrays.asList(0, 0, 1, 0, 0, 0, 0))
				.build();
		
		SubmitBillingResponse billingDataResponse = SubmitBillingResponse.builder()
				.lancamentos(Arrays.asList(barCodeDataResponse))
				.build();
				
		
		when(submitBilling.execute(sendBillingToBankRequest)).thenReturn(billingDataResponse);
		processBilling.execute(sendBillingToBankRequest);
//		verify(processBilling, times(1)).execute(sendBillingToBankRequest);
	}
}
