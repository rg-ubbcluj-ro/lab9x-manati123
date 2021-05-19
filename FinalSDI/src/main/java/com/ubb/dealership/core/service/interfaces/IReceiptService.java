package com.ubb.dealership.core.service.interfaces;

import com.ubb.dealership.core.domain.Receipt;

import java.util.List;

public interface IReceiptService {
    /**
     *
     * @param purchaseId
     * @param totalPrice
     */
    void addReceipt(Long purchaseId, double totalPrice);

    /**
     *
     * @return
     */
    List<Receipt> getAllReceipts();
}
