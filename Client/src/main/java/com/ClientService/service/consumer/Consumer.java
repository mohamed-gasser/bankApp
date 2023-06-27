package com.ClientService.service.consumer;

import com.ClientService.model.dto.certiDto;
import com.ClientService.service.clientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class Consumer {

    private static final String certiTopic = "test";

    private final ObjectMapper objectMapper;
    private final clientService ClientService;


    public Consumer(ObjectMapper objectMapper,@Lazy clientService
            ClientService) {
        this.objectMapper = objectMapper;
        this.ClientService = ClientService;

    }
    @KafkaListener(topics = certiTopic ,groupId="myGroup")
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

         certiDto CertiDto = objectMapper.readValue(message, certiDto.class);
        if(CertiDto.getOperation().equals("del")){
            ClientService.delete(CertiDto);
        }else if(CertiDto.getOperation().equals("upd")){
            ClientService.update(CertiDto, CertiDto.getUpdate_id());
        }else {
            ClientService.save(CertiDto);
        }


    }

}
