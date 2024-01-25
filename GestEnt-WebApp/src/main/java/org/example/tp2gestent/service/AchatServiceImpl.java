package org.example.tp2gestent.service;

import org.example.tp2gestent.model.Achat;
import org.example.tp2gestent.repository.AchatProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AchatServiceImpl {

    @Autowired
    private AchatProxy achatProxy;

    public Iterable<Achat> getAchats(){
        return achatProxy.getAchats();
    }

    public Achat getAchatById(Integer id){
        return achatProxy.getAchat(id);
    }

    public void deleteAchat(Integer id){
        achatProxy.deleteAchat(id);
    }

    public Achat saveAchat(Achat achat) {
        Achat savedAchat;

        if(achat.getAchatId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedAchat = achatProxy.createAchat(achat);
        } else {
            savedAchat = achatProxy.updateAchat(achat);
        }

        return savedAchat;
    }

}
