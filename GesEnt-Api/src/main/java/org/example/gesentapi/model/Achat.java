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
    @OneToMany(cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produit")
    private List<Produit> produitList;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "liste_client",
            joinColumns = @JoinColumn(name = "achat_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clientList;

    @Column(name="date_achat")
    private String dateAchat ;

}
