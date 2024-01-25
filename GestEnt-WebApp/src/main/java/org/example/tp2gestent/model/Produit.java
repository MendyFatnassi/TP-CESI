package org.example.tp2gestent.model;

import lombok.Data;

import java.util.List;

@Data
public class Produit {

    private Integer produitId;
    private String reference;
    private String nom;
    private Double prix;
    private List<Fournisseur> fournisseurList;

}
