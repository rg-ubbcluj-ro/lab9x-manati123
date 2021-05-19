package com.ubb.dealership.core.service.implementations;


import com.ubb.dealership.core.domain.Receipt;
import com.ubb.dealership.core.repository.IReceiptRepository;
import com.ubb.dealership.core.service.interfaces.IReceiptService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ReceiptService implements IReceiptService {
    public static final Logger logger = LoggerFactory.getLogger(ReceiptService.class);


    private final IReceiptRepository repository;

    @Override
    public void addReceipt(Long purchaseId, double totalPrice) {
        logger.trace("addReceipt - method started");
        var newReceipt = new Receipt(purchaseId, totalPrice);
        long id = 0;
        for(Receipt d : this.repository.findAll())
            id = Math.max(id, d.getId() + 1);
        newReceipt.setId(id);
        var result = repository.save(newReceipt);
        logger.trace("addReceipt - method done");
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return this.repository.findAll();
    }
}
