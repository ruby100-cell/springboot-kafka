package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		LOGGER.info("Message sent %s", message);
		kafkaTemplate.send(topicName, message);
	}

}
