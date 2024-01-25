package org.example.gesentapi.service;

import org.example.gesentapi.model.Entreprise;
import org.example.gesentapi.repository.EntrepriseRepository;
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

    public void deleteEntreprise (Integer id){
        entrepriseRepository.deleteById(id);
    }

    public Entreprise save(Entreprise entreprise){
        return entrepriseRepository.save(entreprise);
    }
}
