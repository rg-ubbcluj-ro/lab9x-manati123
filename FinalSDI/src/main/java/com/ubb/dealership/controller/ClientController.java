package com.ubb.dealership.controller;

import com.ubb.dealership.converter.ClientConverter;
import com.ubb.dealership.core.domain.Client;
import com.ubb.dealership.core.service.implementations.ClientService;
import com.ubb.dealership.dto.ClientDto;
import com.ubb.dealership.dto.CollectionDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.stream.Collectors;


@AllArgsConstructor
@RestController
public class ClientController {
    public static Logger logger = LoggerFactory.getLogger(ClientController.class);


    private final ClientService service;


    private final ClientConverter converter;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    ResponseEntity<?> addClient(@RequestBody ClientDto clientDto) {
        logger.info("Adding client.");
        service.addClient(clientDto.getName(), clientDto.getAddress(), clientDto.getPhoneNumber());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        logger.info("Updating client.");
        service.updateClient(id, clientDto.getName(), clientDto.getAddress(), clientDto.getPhoneNumber().toString());
       // System.out.println(id+ clientDto.getName()+ clientDto.getAddress()+ clientDto.getPhoneNumber());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long id) {
        logger.info("Deleting client.");
        service.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    CollectionDto<Long, ClientDto> getClients() {
        logger.info("Requesting clients.");
        return new CollectionDto<>(service.getAllClients()
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList()));
    }






}
