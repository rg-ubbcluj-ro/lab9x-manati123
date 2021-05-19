package com.ubb.dealership.dto;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode()
@ToString(callSuper = true)
public class ClientDroidPrimaryKeyDTO{
    Long droidId, clientId;
    int totalPrice;

}
