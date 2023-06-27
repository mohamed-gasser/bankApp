package com.BankService.Bank.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.BankService.Bank.model.Certificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
@Slf4j
@Component
public class Producer {

    private final String certiTopic = "test";
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger logs= LoggerFactory.getLogger(Producer.class);
    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate , ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper =  objectMapper;
    }
    public String sendMessage(Certificate Data) throws JsonProcessingException
    {
        String CertificateAsMessage= objectMapper.writeValueAsString(Data);
        kafkaTemplate.send(certiTopic, CertificateAsMessage);

        logs.info(String.format("Certification published successfully > %s",Data.toString()));
        return "Publich sent";

    }

}
