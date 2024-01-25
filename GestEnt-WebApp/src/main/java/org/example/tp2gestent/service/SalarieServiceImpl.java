package org.example.tp2gestent.service;

import lombok.extern.slf4j.Slf4j;
import org.example.tp2gestent.model.Produit;
import org.example.tp2gestent.model.Salarie;
import org.example.tp2gestent.repository.SalarieProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SalarieServiceImpl {

    @Autowired
    private SalarieProxy salarieProxy;

    public Iterable<Salarie> getSalaries(){
        return salarieProxy.getSalaries();
    }

    public Salarie getSalarieById(Integer id){
        return salarieProxy.getSalarie(id);
    }

    public void deleteSalarie(Integer id){
        salarieProxy.deleteSalarie(id);
    }

    public Salarie saveSalarie(Salarie salarie) {
        Salarie savedSalarie;

        if(salarie.getSalarieId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedSalarie = salarieProxy.createSalarie(salarie);
        } else {
            savedSalarie = salarieProxy.updateSalarie(salarie);
        }

        return savedSalarie;
    }}
