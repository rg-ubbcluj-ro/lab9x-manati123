package com.ubb.dealership.core.service.interfaces;

import com.ubb.dealership.core.domain.Client;
import com.ubb.dealership.core.domain.Purchase;

import java.util.Collection;
import java.util.List;

public interface IClientService {
    /**
     *
     * @param name
     * @param addr
     * @param phoneNr
     */
    void addClient(String name, String addr, String phoneNr);// returns message

    /**
     *
     * @param id
     */
    void deleteClient(Long id);

    /**
     *
     * @param id
     * @param name
     * @param addr
     * @param phoneNr
     */
    void updateClient(Long id, String name, String addr, String phoneNr);



    /**
     *
     * @return
     */
    List<Client> getAllClients();


}
