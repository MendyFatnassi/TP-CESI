package org.example.gesentapi.service;


import org.example.gesentapi.model.Produit;
import org.example.gesentapi.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitServiceImpl {

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
