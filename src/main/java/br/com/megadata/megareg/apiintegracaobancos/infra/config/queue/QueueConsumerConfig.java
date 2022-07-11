package br.com.megadata.megareg.apiintegracaobancos.infra.config.queue;

/** adaptação da classe de configuração do KAFKA criada pelo PauloTroccoli
* @author Edson Cicero
* @since 16/04/2022
*/

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;

@EnableKafka
@Configuration
public class QueueConsumerConfig {
	
	@Value("${megareg.queue.server}")
	private String server;
	
	@Value("${megareg.queue.group_id}")
	private String grupoWork;
	
	@Value("${megareg.queue.topic-taxa-contrato-detran-pagar}")
	private String emissaoTaxaContratoDetran;
	
	@Value("${megareg.queue.topic-taxa-contrato-detran-consultar}")
	private String consultaTaxaContratoDetran;
		
	@Bean
    public ConsumerFactory<String, String> consumerFactory() {
		
        Map<String, Object> props = new HashMap<>();
        props.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        props.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put( ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
        props.put( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put( ConsumerConfig.GROUP_ID_CONFIG, grupoWork);

        return new DefaultKafkaConsumerFactory<>(props);
    }
	
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(AckMode.MANUAL);
        return factory;
    }
    
	@Bean
	public String emissaoTaxaContratoDetran() {
	    return emissaoTaxaContratoDetran;
    }
	
	@Bean
	public String consultaTaxaContratoDetran() {
	    return consultaTaxaContratoDetran;
    }
	
	@Bean
	public String grupoWork() {
	    return grupoWork;
    }

}
