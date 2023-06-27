package com.BankService.Bank.service;
import com.BankService.Bank.service.producer.Producer;
import com.BankService.Bank.model.Certificate;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class bankService {
    private final  Producer producer;
    private static final Logger logs= LoggerFactory.getLogger(bankService.class);
    @Autowired
    public bankService(Producer producer) {

        this.producer = producer;
    }

    public String sendInfo(Certificate Data)throws JsonProcessingException {
       logs.info(String.format("Certification published successfully"));
        return producer.sendMessage(Data);


    }

}
