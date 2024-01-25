package org.example.gesentapi.controller;

import org.example.gesentapi.model.Fournisseur;
import org.example.gesentapi.model.Produit;
import org.example.gesentapi.model.Salarie;
import org.example.gesentapi.service.SalarieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalarieController {


    @Autowired
    SalarieServiceImpl salarieService;


    @GetMapping("/salaries")
    public Iterable<Salarie> getSalaries(){
        return salarieService.getSalaries();
    }

    @GetMapping("/salarie/{id}")
    public Salarie getSalarie(@PathVariable("id") Integer id){
        Optional<Salarie> salarie = salarieService.getSalarieById(id);
        if(salarie.isPresent()){
            return salarie.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("/salarie")
    public Salarie createSalarie(@RequestBody Salarie salarie){
        return salarieService.save(salarie);
    }

    @DeleteMapping("/salarie/{id}")
    public void deleteSalarie(@PathVariable("id") final Integer id) {
        salarieService.deleteSalarie(id);
    }

    @PutMapping("/salarie/{id}")
    public Salarie updateSalarie(@PathVariable("id") final Integer id, @RequestBody Salarie salarie) {
        Optional<Salarie> salarieTemp = salarieService.getSalarieById(id);
        if(salarieTemp.isPresent()) {
            Salarie currentSalarie = salarieTemp.get();

            Integer idSalarie = salarie.getSalarieId();
            if(idSalarie != null) {
                currentSalarie.setSalarieId(idSalarie);
            }

            String matricule = salarie.getMatricule();
            if(matricule != null){
                currentSalarie.setMatricule(matricule);
            }

            String departement = salarie.getDepartement();
            if(departement != null){
                currentSalarie.setDepartement(departement);
            }

            String poste = salarie.getPoste();
            if(poste != null) {
                currentSalarie.setPoste(poste);
            }

            salarieService.save(currentSalarie);
            return currentSalarie;
        } else {
            return null;
        }
    }
}
