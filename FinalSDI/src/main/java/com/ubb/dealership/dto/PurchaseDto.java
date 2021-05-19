package com.ubb.dealership.dto;

import com.ubb.dealership.core.domain.Client;
import com.ubb.dealership.core.domain.ClientDroidPrimaryKey;
import com.ubb.dealership.core.domain.Droid;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PurchaseDto extends Dto<ClientDroidPrimaryKey> {
    private Client client;
    private Droid droid;
    private double totalPrice;
}