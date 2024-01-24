package org.example.tp2gestent.repository;

import org.example.tp2gestent.model.Salarie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarieRepository extends CrudRepository<Salarie,Integer> {
}
