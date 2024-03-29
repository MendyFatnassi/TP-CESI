package org.example.gesentapi.controller;

import org.example.gesentapi.model.Achat;
import org.example.gesentapi.model.Produit;
import org.example.gesentapi.service.AchatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Achatcontroller {

    @Autowired
    AchatServiceImpl achatService;


    @GetMapping("/achats")
    public Iterable<Achat> getAchats(){
        return achatService.getAchats();
    }

    @GetMapping("/achat/{id}")
    public Achat getAchat(@PathVariable ("id") Integer id){
        Optional<Achat> achat = achatService.getAchatById(id);
        if(achat.isPresent()){
            return achat.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("/achat")
    public Achat createAchat(@RequestBody Achat achat){
        return achatService.save(achat);
    }

    @DeleteMapping("/achat/{id}")
    public void deleteAchat(@PathVariable("id") final Integer id) {
        achatService.deleteAchat(id);
    }

    @PutMapping("/achat/{id}")
    public Achat updateAchat(@PathVariable("id") final Integer id, @RequestBody Achat achat) {
        Optional<Achat> achatTemp = achatService.getAchatById(id);
        if(achatTemp.isPresent()) {
            Achat currentAchat = achatTemp.get();

            Integer idAchat = achat.getAchatId();
            if(idAchat != null) {
                currentAchat.setAchatId(idAchat);
            }

            Integer numAchat = achat.getNumeroAchat();
            if(numAchat != null){
                currentAchat.setNumeroAchat(numAchat);
            }

            List<Produit> produitList = achat.getProduitList();
            if(produitList != null){
                currentAchat.setProduitList(produitList);
            }

            String date = achat.getDateAchat();
            if(date != null){
                currentAchat.setDateAchat(date);
            }

            achatService.save(currentAchat);
            return currentAchat;
        } else {
            return null;
        }
    }
}
