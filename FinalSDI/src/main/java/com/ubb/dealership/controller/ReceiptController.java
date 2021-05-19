package com.ubb.dealership.controller;


import com.ubb.dealership.converter.ReceiptConverter;
import com.ubb.dealership.core.domain.Receipt;
import com.ubb.dealership.core.service.implementations.ReceiptService;
import com.ubb.dealership.dto.CollectionDto;
import com.ubb.dealership.dto.ReceiptDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@AllArgsConstructor
@RestController
public class ReceiptController {
    public static Logger logger = LoggerFactory.getLogger(ReceiptController.class);

    private final ReceiptService service;

    private final ReceiptConverter converter;

    @RequestMapping(value = "/receipts", method = RequestMethod.PUT)
    ResponseEntity<?> addReceipt(@RequestBody ReceiptDto receipt) {
        logger.info("Purchase id: " + receipt.getPurchaseID() + "Price: " + receipt.getTotalPrice());
        service.addReceipt(receipt.getPurchaseID(), receipt.getTotalPrice());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/receipts", method = RequestMethod.GET)
    CollectionDto<Long, ReceiptDto> getAllReceipts() {
        return new CollectionDto<Long, ReceiptDto>(service.getAllReceipts()
                .stream()
                .map(receipt -> converter.toDto(receipt))
                .collect(Collectors.toList()));
    }



}
