package org.example.gesentapi.repository;


import org.example.gesentapi.model.Entreprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise,Integer> {
}
