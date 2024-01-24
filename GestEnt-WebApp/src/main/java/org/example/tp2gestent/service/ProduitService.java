package org.example.tp2gestent.service;

import org.example.tp2gestent.model.Achat;
import org.example.tp2gestent.model.Client;
import org.example.tp2gestent.model.Produit;
import org.example.tp2gestent.repository.AchatRepository;
import org.example.tp2gestent.repository.ClientRepository;
import org.example.tp2gestent.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Iterable<Produit> getProduits(){
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Integer id){
        return produitRepository.findById(id);
    }


    public void deleteProduit(Integer id){
        produitRepository.deleteById(id);
    }

    public Produit save (Produit produit){
        return produitRepository.save(produit);
    }

}
