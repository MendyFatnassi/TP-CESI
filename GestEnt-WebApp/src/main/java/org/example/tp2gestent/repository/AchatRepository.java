package org.example.tp2gestent.repository;

import org.example.tp2gestent.model.Achat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatRepository extends CrudRepository<Achat,Integer> {
}
