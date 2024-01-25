package org.example.gesentapi.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Builder
@Data
@Entity
@Table(name="fournisseur")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_fournisseur")
    private Integer fournisseurId;

    @Column(name="numeros_fournie")
    private Integer numerosFournie;

    @Column(name = "produit_fournie")
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_achat")
    private List<Achat> produitFournie;
}