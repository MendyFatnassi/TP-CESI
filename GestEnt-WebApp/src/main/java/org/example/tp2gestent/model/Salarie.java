package org.example.tp2gestent.model;

import lombok.Data;

@Data
public class Salarie {

    private Integer salarieId;
    private String matricule;
    private String departement;
    private String poste;
    private Double salaire;

}