package com.ubb.dealership.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReceiptDto extends Dto<Long> {
    private Long purchaseID;
    double totalPrice;
}