package org.example.gesentapi.service;


import org.example.gesentapi.model.Client;
import org.example.gesentapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl {

    @Autowired
    private ClientRepository clientRepository;

    public Iterable<Client> getClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id){
        return clientRepository.findById(id);
    }

    public void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

}
