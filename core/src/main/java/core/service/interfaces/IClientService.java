package core.service.interfaces;

import core.domain.Client;

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
