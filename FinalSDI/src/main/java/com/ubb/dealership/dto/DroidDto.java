package com.ubb.dealership.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString(callSuper = true)
public class DroidDto extends Dto<Long>{
    private double powerUsage;
    private double price;
    private int batteryTime;
    private String model;
    private boolean driver;
}