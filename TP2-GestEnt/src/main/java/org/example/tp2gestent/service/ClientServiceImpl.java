package org.example.tp2gestent.service;

import org.example.tp2gestent.model.Client;
import org.example.tp2gestent.repository.ClientRepository;
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

    public Optional<Client> getCientById(Integer id){
        return clientRepository.findById(id);
    }


}
