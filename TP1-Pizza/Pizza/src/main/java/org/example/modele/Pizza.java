package org.example.modele;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Pizza {

    private Integer id_pizza;
    private String nom;
    private String description;
    private double prix;

    public Pizza (){}

    public Pizza(Integer id,String nom , String description , Double prix){
         this.id_pizza = id;
         this.nom = nom;
         this.description=description;
         this.prix=prix;
    }
}
