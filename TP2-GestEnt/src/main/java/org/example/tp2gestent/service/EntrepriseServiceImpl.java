package org.example.tp2gestent.service;


import org.example.tp2gestent.model.Entreprise;
import org.example.tp2gestent.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrepriseServiceImpl {
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public Iterable<Entreprise> getEntreprises(){
        return entrepriseRepository.findAll();
    }

    public Optional<Entreprise> getEntrepriseById(Integer id){
        return entrepriseRepository.findById(id);
    }

}
