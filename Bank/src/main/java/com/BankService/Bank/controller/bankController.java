package com.BankService.Bank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BankService.Bank.model.Certificate;
import com.BankService.Bank.service.bankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api")
public class bankController {
    private final bankService BankService;
    private static final Logger logs= LoggerFactory.getLogger(bankService.class);
    @Autowired
    public bankController(bankService BankService) {

        this.BankService = BankService;
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Certificate Data) throws JsonProcessingException {
        logs.info(String.format("Certification %s inserted successfully",Data.toString()));
        return BankService.sendInfo(Data);

    }


    @DeleteMapping("/delete")
    public String delete(@RequestBody Certificate Data) throws JsonProcessingException {
        Data.setOperation("del");
        logs.info(String.format("Certification %s Deleted successfully",Data.toString()));
        return BankService.sendInfo(Data);
    }

    @PutMapping("/update")
    public String update(@RequestBody Certificate Data, @RequestParam Long id) throws JsonProcessingException {
        Data.setOperation("upd");
        Data.setUpdate_id(id);
        logs.info(String.format("Certification %s updated successfully",Data.toString()));
        return BankService.sendInfo(Data);
    }

}
