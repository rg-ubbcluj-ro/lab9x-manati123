package web.controller;

import core.service.implementations.ClientService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.ClientConverter;
import web.dto.ClientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.dto.CollectionDto;

import java.util.stream.Collectors;


@RestController
public class ClientController {
    public static Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService service;

    @Autowired
    private ClientConverter converter;

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    ResponseEntity<?> addClient(@RequestBody ClientDto clientDto) {
        logger.info("Adding client.");
        service.addClient(clientDto.getName(), clientDto.getAddress(), clientDto.getPhoneNumber());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
    ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        logger.info("Updating client.");
        service.updateClient(id, clientDto.getName(), clientDto.getAddress(), clientDto.getPhoneNumber());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
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
                .map(client -> converter.toDto(client))
                .collect(Collectors.toList()));
    }






}
