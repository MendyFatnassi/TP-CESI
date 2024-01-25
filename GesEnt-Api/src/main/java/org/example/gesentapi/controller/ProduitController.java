package org.example.gesentapi.controller;

import org.example.gesentapi.model.Fournisseur;
import org.example.gesentapi.model.Produit;
import org.example.gesentapi.service.ProduitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProduitController {

    @Autowired
    ProduitServiceImpl produitService;


    @GetMapping("/produits")
    public Iterable<Produit> getProduits(){
        return produitService.getProduits();
    }

    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable("id") Integer id){
        Optional<Produit> produit = produitService.getProduitById(id);
        if(produit.isPresent()){
            return produit.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("/produit")
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.save(produit);
    }

    @DeleteMapping("/produit/{id}")
    public void deleteProduit(@PathVariable("id") final Integer id) {
        produitService.deleteProduit(id);
    }

    @PutMapping("/produit/{id}")
    public Produit updateProduit(@PathVariable("id") final Integer id, @RequestBody Produit produit) {
        Optional<Produit> produitTemp = produitService.getProduitById(id);
        if(produitTemp.isPresent()) {
            Produit currentProduit = produitTemp.get();

            Integer idProduit = produit.getProduitId();
            if(idProduit != null) {
                currentProduit.setProduitId(idProduit);
            }

            String ref = produit.getReference();
            if(ref != null){
                currentProduit.setReference(ref);
            }

            String nom = produit.getNom();
            if(nom != null){
                currentProduit.setNom(nom);
            }

            Double prix = produit.getPrix();
            if(produit != null){
                currentProduit.setPrix(prix);
            }

            List<Fournisseur> fournisseurList = produit.getFournisseurList();
            if(fournisseurList != null){
                currentProduit.setFournisseurList(fournisseurList);
            }

            produitService.save(currentProduit);
            return currentProduit;
        } else {
            return null;
        }
    }
}
