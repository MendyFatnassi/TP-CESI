package org.example.tp2gestent.service;


import org.example.tp2gestent.model.Achat;
import org.example.tp2gestent.model.Entreprise;
import org.example.tp2gestent.repository.EntrepriseProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrepriseServiceImpl {
    @Autowired
    private EntrepriseProxy entrepriseProxy;

    public Iterable<Entreprise> getEntreprises(){
        return entrepriseProxy.getEntreprises();
    }

    public Entreprise getEntrepriseById(Integer id){
        return entrepriseProxy.getEntreprise(id);
    }

    public void deleteEntreprise (Integer id){
        entrepriseProxy.deleteEntreprise(id);
    }

    public Entreprise saveEntreprise(Entreprise entreprise) {
        Entreprise savedEntreprise;

        if(entreprise.getEntrepriseId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEntreprise = entrepriseProxy.createEntreprise(entreprise);
        } else {
            savedEntreprise = entrepriseProxy.updateEntreprise(entreprise);
        }

        return savedEntreprise;
    }
}
