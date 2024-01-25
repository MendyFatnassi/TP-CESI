package org.example.gesentapi.controller;

import org.example.gesentapi.model.Achat;
import org.example.gesentapi.model.Client;
import org.example.gesentapi.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;


    @GetMapping("/clients")
    public Iterable<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable("id") Integer id){
        Optional<Client> client = clientService.getClientById(id);
        if(client.isPresent()){
            return client.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") final Integer id) {
        clientService.deleteClient(id);
    }

    @PutMapping("/achate/{id}")
    public Client updateAchat(@PathVariable("id") final Integer id, @RequestBody Client client) {
        Optional<Client> clientTemp = clientService.getClientById(id);
        if(clientTemp.isPresent()) {
            Client currentClient = clientTemp.get();

            Integer idAchat = client.getClientId();
            if(idAchat != null) {
                currentClient.setClientId(idAchat);
            }

            Integer numClient = client.getNumeroClient();
            if(numClient != null){
                currentClient.setNumeroClient(numClient);
            }

            List<Achat> achatList = client.getHistoriqueAchat();
            if(achatList != null){
                currentClient.setHistoriqueAchat(achatList);
            }

            clientService.save(currentClient);
            return currentClient;
        } else {
            return null;
        }
    }
}
