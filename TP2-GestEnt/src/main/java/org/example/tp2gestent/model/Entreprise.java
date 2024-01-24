package org.example.tp2gestent.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
@Table(name="entreprise")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_entreprise")
    private Integer entrepriseId;

    @Column(name="nom")
    private String nom;

    @Column(name="siret")
    private String siret;

    @Column(name="adresse")
    private String adresse;

    @Column
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_salarie")
    private List<Salarie> listEmployer;

    @Column(name = "produit_liste")
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit")
    private List<Produit> produitList ;

    @Column(name = "achat_liste")
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_achat")
    private List<Achat> achatList;


}
