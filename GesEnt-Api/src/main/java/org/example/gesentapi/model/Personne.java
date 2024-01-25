package org.example.gesentapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Personne {

    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;

    public Personne(String nom,String prenom,String telephone,String adresse){
        this.nom=nom;
        this.prenom=prenom;
        this.telephone=telephone;
        this.adresse=adresse;
    }

    public Personne() {

    }
}