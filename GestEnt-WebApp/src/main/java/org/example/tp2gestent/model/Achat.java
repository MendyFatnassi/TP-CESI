package org.example.tp2gestent.model;

import lombok.Data;


@Data
public class Achat {

    private Integer achatId;
    private Integer numeroAchat;
    private Integer produitList;
    private Integer clientList;
    private String dateAchat ;

}
