package org.example.tp2gestent.service;

import org.example.tp2gestent.model.Client;
import org.example.tp2gestent.repository.ClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientServiceImpl {

    @Autowired
    private ClientProxy clientProxy;

    public Iterable<Client> getClients(){
        return clientProxy.getClients();
    }

    public Client getClientById(Integer id){
        return clientProxy.getClient(id);
    }

    public void deleteClient(Integer id){
        clientProxy.deleteClient(id);
    }

    public Client save(Client client){
        return clientProxy.createClient(client);
    }

}
