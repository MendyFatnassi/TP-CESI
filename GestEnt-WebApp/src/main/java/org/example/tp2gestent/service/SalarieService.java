package org.example.tp2gestent.service;

import org.example.tp2gestent.model.Achat;
import org.example.tp2gestent.model.Salarie;
import org.example.tp2gestent.repository.AchatRepository;
import org.example.tp2gestent.repository.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SalarieService {

    @Autowired
    private SalarieRepository salarieRepository;

    public Iterable<Salarie> getAchats(){
        return salarieRepository.findAll();
    }

    public Optional<Salarie> getAchatById(Integer id){
        return salarieRepository.findById(id);
    }d

    public void deleteAchat(Integer id){
        salarieRepository.deleteById(id);
    }

    public Salarie save (Salarie salarie){
        return salarieRepository.save(salarie);
    }
}
