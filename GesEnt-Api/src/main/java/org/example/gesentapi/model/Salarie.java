package org.example.gesentapi.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@Entity
@Table(name = "salarie")
public class Salarie {

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