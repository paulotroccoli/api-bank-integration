//package br.com.megadata.megareg.apiintegracaobancos.entrypoint.queue;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.concurrent.TimeUnit;
//
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.test.context.EmbeddedKafka;
//
//import br.com.megadata.megareg.apiintegracaobancos.infra.config.queue.ProducerKafka;
//
//@SpringBootTest
//@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://10.21.31.235:9092", "port=9092" })
//public class QueueBillingTest {
//	
//	@Autowired
//    private KafkaConsumer consumer;
//
//    @Autowired
//    private ProducerKafka producer;
//    
//    @Value("${megareg.queue.topic-taxa-contrato-detran-pagar}")
//    private String topic;
//
//	@Test
//	@Ignore
//	public void queueBillingTest() {
//		
//		Long data = 1L;
//        
//        producer.addQueueProcessarContrato(data);
//        
////        boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);
////        assertTrue(messageConsumed);
////        assertThat(consumer.getPayload(), containsString(data));
//	}
//}
