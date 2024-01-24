package org.example.tp2gestent.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "salarie")
public class Salarie extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salarie")
    private Integer salarieId;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "departement")
    private String departement;

    @Column(name = "poste")
    private String poste;

    @Column(name = "salaire")
    private Double salaire;

}