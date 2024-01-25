package org.example.gesentapi.repository;

import org.example.gesentapi.model.Achat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatRepository extends CrudRepository<Achat,Integer> {
}
