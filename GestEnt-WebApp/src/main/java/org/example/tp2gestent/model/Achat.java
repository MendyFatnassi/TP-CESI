package org.example.tp2gestent.model;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class Achat {

    private Integer achatId;
    private Integer numeroAchat;
    private List<Produit> produitList;
    private List<Client> clientList;
    private String dateAchat ;

}
