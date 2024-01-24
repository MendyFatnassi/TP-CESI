package org.example.tp2gestent.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Personne {

    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;

}