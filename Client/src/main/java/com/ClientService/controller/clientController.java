package com.ClientService.controller;

import com.ClientService.model.Certificate;
import com.ClientService.service.clientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class clientController {

    private clientService ClientService;
    private static final Logger logs= LoggerFactory.getLogger(clientService.class);

    public clientController(@Lazy clientService ClientService) {
        this.ClientService = ClientService;
    }


    @GetMapping("/getAll")
    public List<Certificate> findAll() {
        logs.info(String.format(" All Certification is Display Successfully"));
        return ClientService.findAll();
    }

    @GetMapping("/getByID")
    public Certificate findById(@RequestParam Long id) {

        return ClientService.findById(id);
    }

    @GetMapping("/getByName")
    public Certificate findByName(@RequestParam String name) {

        return ClientService.findByName(name);
    }




}
