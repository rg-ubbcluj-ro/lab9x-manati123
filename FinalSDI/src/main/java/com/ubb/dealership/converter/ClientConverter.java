package com.ubb.dealership.converter;


import com.ubb.dealership.core.domain.Client;
import com.ubb.dealership.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter implements Converter<Long, Client, ClientDto> {

    @Override
    public ClientDto toDto(Client model) {
        ClientDto client = new ClientDto();
        client.setAddress(model.getAddress());
        client.setName(model.getName());
        client.setPhoneNumber(model.getPhoneNumber());
        client.setId(model.getId());
        return client;
    }
}