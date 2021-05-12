package web.controller;


import core.domain.ClientDroidPrimaryKey;
import core.service.implementations.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.converter.PurchaseConverter;
import web.dto.CollectionDto;
import web.dto.PurchaseDto;

import java.util.stream.Collectors;

@RestController
public class PurchaseController {
    public static Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    PurchaseService service;

    @Autowired
    PurchaseConverter converter;

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    ResponseEntity<?> addPurchase(@RequestBody PurchaseDto dto) {
        service.addPurchase(dto.getClient().getId(), dto.getDroid().getId(), dto.getTotalPrice());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/purchase/{client_id}&{droid_id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deletePurchase(@PathVariable Long client_id,@PathVariable Long droid_id) {
        service.deletePurchase(client_id,droid_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    CollectionDto<ClientDroidPrimaryKey, PurchaseDto> getAllPurchases() {
        return new CollectionDto<>(service.getAllPurchases()
                .stream()
                .map(p -> converter.toDto(p))
                .collect(Collectors.toList()));
    }
}