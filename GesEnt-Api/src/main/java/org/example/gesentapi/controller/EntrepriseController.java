package org.example.gesentapi.controller;

import org.example.gesentapi.model.*;
import org.example.gesentapi.service.EntrepriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntrepriseController {

    @Autowired
    EntrepriseServiceImpl entrepriseService;


    @GetMapping("/entreprises")
    public Iterable<Entreprise> getEntreprises(){
        return entrepriseService.getEntreprises();
    }

    @GetMapping("/entreprise/{id}")
    public Entreprise getEntreprise(@PathVariable("id") Integer id){
        Optional<Entreprise> entreprise = entrepriseService.getEntrepriseById(id);
        if(entreprise.isPresent()){
            return entreprise.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("/entreprise")
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise){
        return entrepriseService.save(entreprise);
    }

    @DeleteMapping("/entreprise/{id}")
    public void deleteEntreprise(@PathVariable("id") final Integer id) {
        entrepriseService.deleteEntreprise(id);
    }

    @PutMapping("/entreprise/{id}")
    public Entreprise updateAchat(@PathVariable("id") final Integer id, @RequestBody Entreprise entreprise) {
        Optional<Entreprise> entTemp = entrepriseService.getEntrepriseById(id);
        if(entTemp.isPresent()) {
            Entreprise currentEntreprise = entTemp.get();

            Integer idEntreprise = entreprise.getEntrepriseId();
            if(idEntreprise != null) {
                currentEntreprise.setEntrepriseId(idEntreprise);
            }

            String nom = entreprise.getNom();
            if(nom != null){
                currentEntreprise.setNom(nom);
            }

            String siret = entreprise.getSiret();
            if(siret != null){
                currentEntreprise.setSiret(siret);
            }

            String adresse = entreprise.getAdresse();
            if(adresse != null){
                currentEntreprise.setAdresse(adresse);
            }

            List<Salarie> salarieList = entreprise.getListEmployer();
            if(salarieList != null){
                currentEntreprise.setListEmployer(salarieList);
            }

            List<Produit> produitList = entreprise.getProduitList();
            if(produitList != null){
                currentEntreprise.setProduitList(produitList);
            }

            List<Achat> achatList = entreprise.getAchatList();
            if(achatList != null){
                currentEntreprise.setAchatList(achatList);
            }

            entrepriseService.save(currentEntreprise);
            return currentEntreprise;
        } else {
            return null;
        }
    }
}
