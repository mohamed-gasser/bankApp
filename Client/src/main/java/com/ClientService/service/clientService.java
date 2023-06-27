package com.ClientService.service;
import java.util.List;
import java.util.Optional;


import com.ClientService.model.Certificate;
import com.ClientService.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.ClientService.model.dto.certiDto;
import org.modelmapper.ModelMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class clientService {
    private final Repo clientRepository;
    private  final ModelMapper modelMapper;
    private static final Logger logs= LoggerFactory.getLogger(clientService.class);

    public clientService(@Lazy Repo clientRepository, ModelMapper modelMapper) {
        this.modelMapper=modelMapper;
        this.clientRepository = clientRepository;
    }

    public List<Certificate> findAll() {
        return clientRepository.findAll();
    }

    public Certificate findById(Long id) {
        Optional<Certificate> certificate = clientRepository.findById(id);
        return certificate.orElse(null);
    }

   public Certificate findByName(String name) {
       return clientRepository.findByQuery(name);
          }

    public void delete(certiDto CertiDto) {
        Long id=clientRepository.getID(CertiDto.getName(),CertiDto.getYears());

        clientRepository.deleteById(id);

    }


    public void save(certiDto CertiDto) {
        Certificate Certificate =modelMapper.map(CertiDto, Certificate.class);
        Certificate save=clientRepository.save(Certificate);


    }

    public Certificate update(certiDto certificate, Long id) {
        //Certificate updatedCertificate =modelMapper.map(certificate, Certificate.class);
        Optional<Certificate> oldData = clientRepository.findById(id);
        if (oldData.isPresent()) {
            Certificate Certificate = oldData.get();
            Certificate.setId(id);
            Certificate.setName(certificate.getName());
            Certificate.setYears(certificate.getYears());
            Certificate.setProfit(certificate.getProfit());
            Certificate.setPrice(certificate.getPrice());
            return clientRepository.save(Certificate);
        } else
            return null;
    }

}
