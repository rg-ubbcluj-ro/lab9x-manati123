package com.ubb.dealership.controller;


import com.ubb.dealership.converter.PurchaseConverter;
import com.ubb.dealership.converter.PurchasesConverter;
import com.ubb.dealership.core.domain.ClientDroidPrimaryKey;
import com.ubb.dealership.core.service.implementations.ClientService;
import com.ubb.dealership.core.service.implementations.DroidService;
import com.ubb.dealership.core.service.implementations.PurchaseService;
import com.ubb.dealership.dto.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:8081")
@AllArgsConstructor
@RestController
public class PurchaseController {
    public static Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    private final PurchaseService service;

    private final PurchaseConverter converter;

    private final PurchasesConverter purchasesConverter;

    private final DroidService droidService;

    private final ClientService clientService;

    @RequestMapping(value = "/purchases", method = RequestMethod.POST)
    ResponseEntity<?> addPurchase(@RequestBody ClientDroidPrimaryKeyDTO dto) {
        service.addPurchase(dto.getClientId(), dto.getDroidId(), dto.getTotalPrice());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    CollectionDto<ClientDroidPrimaryKey, PurchaseDto> getAllPurchases() {
        return new CollectionDto<>(service.getAllPurchases()
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/sortedPurchases", method = RequestMethod.GET)
    CollectionDto<ClientDroidPrimaryKey, PurchaseDto> getFilteredPurchases(){
        return new CollectionDto<>((service.getAllPurchases()
                .stream()
                .map(converter::toDto)
                .sorted(Comparator.comparing(PurchaseDto::getTotalPrice))
                .collect(Collectors.toList())));

    }




}