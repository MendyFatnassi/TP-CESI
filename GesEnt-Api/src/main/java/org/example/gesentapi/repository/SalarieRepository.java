package org.example.gesentapi.repository;


import org.example.gesentapi.model.Salarie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarieRepository extends CrudRepository<Salarie,Integer> {
}
