package com.ricardo.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).addCallback(
                SUCCESS -> {
                    if(SUCCESS != null){
                        log.info("Send message with success {}", message);
                        log.info("Partition {}, Offiset {}", SUCCESS.getRecordMetadata().partition(), SUCCESS.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Error send message")
        );
    }
}
