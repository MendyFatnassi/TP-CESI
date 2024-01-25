package org.example.tp2gestent.model;

import lombok.Data;

import java.util.List;


@Data
public class Fournisseur {


    private Integer fournisseurId;
    private Integer numerosFournie;
    private List<Achat> produitFournie;

}