package com.ubb.dealership.converter;

import com.ubb.dealership.core.domain.ClientDroidPrimaryKey;
import com.ubb.dealership.core.domain.Purchase;
import com.ubb.dealership.dto.PurchaseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PurchasesConverter  extends BaseConverter<ClientDroidPrimaryKey, Purchase, PurchaseDto>{

    private final DroidConverter droidConverter;

    private final ClientConverter clientConverter;
    @Override
    public PurchaseDto toDto(Purchase model) {
        PurchaseDto purchase = new PurchaseDto();
        purchase.setDroid(model.getDroid());
        purchase.setClient(model.getClient());
        purchase.setTotalPrice(model.getTotalPrice());
        purchase.setId(model.getId());
        return purchase;
    }
}
