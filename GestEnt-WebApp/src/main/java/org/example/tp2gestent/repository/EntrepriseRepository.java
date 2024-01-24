package org.example.tp2gestent.repository;

import org.example.tp2gestent.model.Entreprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise,Integer> {
}
