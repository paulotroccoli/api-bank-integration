package br.com.megadata.megareg.apiintegracaobancos.core.service.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.consult.ConsultPayment;
import lombok.AllArgsConstructor;

@Service
@EnableAsync
@AllArgsConstructor
public class ConsultPaymentScheduleService {
	
	private final ConsultPayment consultPayment;

	@Async
	@Scheduled(fixedRateString = "${megareg.milliseconds-scheduled}") // 60 segundos
	public void checkPayment() {

		consultPayment.execute();
			
	}
}
