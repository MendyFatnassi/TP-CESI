package org.example.tp2gestent.service;

import org.example.tp2gestent.model.Achat;
import org.example.tp2gestent.model.Produit;
import org.example.tp2gestent.repository.ProduitProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitServiceImpl {

    @Autowired
    private ProduitProxy produitProxy;

    public Iterable<Produit> getProduits(){
        return produitProxy.getProduits();
    }

    public Produit getProduitById(Integer id){
        return produitProxy.getProduit(id);
    }


    public void deleteProduit(Integer id){
        produitProxy.deleteProduit(id);
    }

    public Produit saveAchat(Produit produit) {
        Produit savedProduit;

        if(produit.getProduitId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedProduit = produitProxy.createProduit(produit);
        } else {
            savedProduit = produitProxy.updateProduit(produit);
        }

        return savedProduit;
    }
}
