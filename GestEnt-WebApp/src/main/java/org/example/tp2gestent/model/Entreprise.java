package org.example.tp2gestent.model;

import lombok.Data;


import java.util.List;

@Data
public class Entreprise {

    private Integer entrepriseId;
    private String nom;
    private String siret;
    private String adresse;
    private List<Salarie> listEmployer;
    private List<Produit> produitList ;
    private List<Achat> achatList;


}
