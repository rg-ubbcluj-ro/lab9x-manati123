package com.ubb.dealership.core.service.implementations;


import com.ubb.dealership.core.domain.Client;
import com.ubb.dealership.core.domain.Purchase;
import com.ubb.dealership.core.exceptions.DealershipException;
import com.ubb.dealership.core.exceptions.NotFoundException;
import com.ubb.dealership.core.repository.IClientRepository;
import com.ubb.dealership.core.service.interfaces.IClientService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static java.lang.Math.max;

@AllArgsConstructor
@Service
public class ClientService implements IClientService {

    public static final Logger logger = LoggerFactory.getLogger(ClientService.class);


    private final IClientRepository repository;

    @Override
    public void addClient(String name, String addr, String phoneNr) {
        logger.trace("addClient - method entered - name: " + name + ", phoneNumber: " + phoneNr);
        long id = 0;
        for (Client Client : this.repository.findAll())
            id = max(id, Client.getId() + 1);
        Client ClientToBeAdded = new Client(id, name,addr, phoneNr);
        repository.save(ClientToBeAdded);
        logger.trace("addClient - method finished");
    }

    @Override
    public void deleteClient(Long id) {
        logger.trace("deleteClient - method entered - id: " + id);

        this.repository.findById(id)
                .ifPresentOrElse((client) -> this.repository.deleteById(client.getId()),
                        () -> {
                    throw new DealershipException("Client does not exist");
                        });
        logger.trace("deleteClient - method done");
    }

    @Override
    public void updateClient(Long id, String name, String addr, String phoneNr) {
        logger.info("updateClient - method entered -"+ "id: " + id + " " + "name: " + name + ", phoneNumber: " + phoneNr);

        this.repository.findById(id)
                .ifPresentOrElse(
                        (client) -> {
                            client.setAddress(addr);
                            client.setName(name);
                            client.setPhoneNumber(phoneNr);
                        },
                        () -> {
                            throw new NotFoundException("Client does not exist!");
                        }
                );
        logger.info("updateClient - method finished");
    }



    @Override
    public List<Client> getAllClients() {
        logger.trace("getAllClient - method started");
        return this.repository.findAll();
    }


}
