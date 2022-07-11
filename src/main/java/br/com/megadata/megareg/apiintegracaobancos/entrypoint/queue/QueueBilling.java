package br.com.megadata.megareg.apiintegracaobancos.entrypoint.queue;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.megadata.megareg.apiintegracaobancos.core.usercase.billing.submit.ProcessBilling;
import br.com.megadata.megareg.apiintegracaobancos.entrypoint.queue.request.ConsumerMessageBase;
import br.com.megadata.megareg.apiintegracaobancos.entrypoint.queue.request.QueueBillingRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class QueueBilling {

	private final ProcessBilling processBilling;
	
	@KafkaListener(topics = "#{@emissaoTaxaContratoDetran}", groupId = "#{@grupoWork}")
	@Transactional
	public void queueBilling(final ConsumerMessageBase<QueueBillingRequest> barCodeDataRequest, final Acknowledgment acknowledgment){
		
		acknowledgment.acknowledge();
		try {
			
			processBilling.execute(barCodeDataRequest.getValue().toSendBillingToBankRequest());
	
		} catch (Exception e) {
			log.error("Erro ao processar fila de emissão de taxa de contrato:" + e.getMessage());
		}
		
	}
}
