package org.example.tp2gestent.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity
@Table(name="produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit")
    private Integer produitId;

    @Column(name = "reference")
    private String reference;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "fournisseurs")
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_fournisseur")
    private List<Fournisseur> fournisseurList;

}
