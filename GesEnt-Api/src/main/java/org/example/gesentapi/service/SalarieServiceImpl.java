package org.example.gesentapi.service;

import org.example.gesentapi.model.Salarie;
import org.example.gesentapi.repository.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalarieServiceImpl {

    @Autowired
    private SalarieRepository salarieRepository;

    public Iterable<Salarie> getSalaries(){
        return salarieRepository.findAll();
    }

    public Optional<Salarie> getSalarieById(Integer id){
        return salarieRepository.findById(id);
    }

    public void deleteSalarie(Integer id){
        salarieRepository.deleteById(id);
    }

    public Salarie save (Salarie salarie){
        return salarieRepository.save(salarie);
    }
}
