package com.ubb.dealership.converter;


import com.ubb.dealership.core.domain.Receipt;
import com.ubb.dealership.dto.ReceiptDto;
import org.springframework.stereotype.Component;

@Component
public class ReceiptConverter implements Converter<Long, Receipt, ReceiptDto> {
    @Override
    public ReceiptDto toDto(Receipt model) {
        var receipt = new ReceiptDto();
        receipt.setId(model.getId());
        receipt.setPurchaseID(model.getPurchaseID());
        receipt.setTotalPrice(model.getTotalPrice());
        return receipt;
    }
}