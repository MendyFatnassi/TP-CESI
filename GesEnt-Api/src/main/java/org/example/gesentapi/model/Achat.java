package org.example.gesentapi.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
@Table(name="achat")
public class Achat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_achat")
    private Integer achatId;

    @Column(name="numero_achat")
    private Integer numeroAchat;

    @Column(name="liste_produit")
    private Integer produitList;

    @Column(name="liste_client")
    private Integer clientList;

    @Column(name="date_achat")
    private String dateAchat ;

}
