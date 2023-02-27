package com.ricardo.jsonconsumer.listener;

import com.ricardo.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonConsumerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Recebi o pagamento {}", payment.toString());
        Thread.sleep(2000);
        log.info("Validando Fraud...");
        Thread.sleep(2000);

        log.info("Compra aprovada...");
        Thread.sleep(4000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonConsumerFactory")
    public void pdfGenerator(@Payload Payment payment){
        log.info("Gerando PDF do produto {}", payment.getId());
        Thread.sleep(3000);

    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonConsumerFactory")
    public void sendEmail(){
        log.info("Enviando Email de confirmação...");
        Thread.sleep(2000);
    }

}
