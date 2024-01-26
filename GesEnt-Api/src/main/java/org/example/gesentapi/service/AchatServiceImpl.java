package org.example.gesentapi.service;

import org.example.gesentapi.model.Achat;
import org.example.gesentapi.repository.AchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AchatServiceImpl {

    @Autowired
    private AchatRepository achatRepository;

    public Iterable<Achat> getAchats(){
        return achatRepository.findAll();
    }

    public Optional<Achat> getAchat(Integer id){
        return achatRepository.findById(id);
    }

    public void deleteAchat(Integer id){
        achatRepository.deleteById(id);
    }

    public Achat saveAchat (Achat achat){
        Achat savedAchat = achatRepository.save(achat);
        return savedAchat;
    }

}
