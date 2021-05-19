package com.ubb.dealership.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ClientDto extends Dto<Long> {
    private String name;
    private String address;
    private String phoneNumber;

//    public String getName(){return name;}
//    public String getAddress(){return address;}
//    public String getPhoneNumber(){return phoneNumber;}
}