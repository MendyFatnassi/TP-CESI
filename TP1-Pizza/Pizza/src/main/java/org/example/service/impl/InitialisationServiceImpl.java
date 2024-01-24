package org.example.service.impl;

import org.example.modele.Pizza;
import org.example.service.InitialisationService;

import java.util.ArrayList;
import java.util.List;

public class InitialisationServiceImpl implements InitialisationService {

   @Override
    public List<Pizza> initPizzaTab(){
        List<Pizza> pizzaList = new ArrayList<>();

        pizzaList.add(Pizza.builder()
                .id_pizza(0)
                .nom("PEP")
                .description("Peperoni")
                .prix(12.50)
                .build()
        );
        pizzaList.add(Pizza.builder()
                .id_pizza(1)
                .nom("MAR")
                .description("Margherita")
                .prix(14.00)
                .build()
        );
        pizzaList.add(Pizza.builder()
                .id_pizza(2)
                .nom("REIN")
                .description("La Reine")
                .prix(11.50)
                .build()
        );
        pizzaList.add(Pizza.builder()
                .id_pizza(3)
                .nom("FRO")
                .description("La 4 Fromage")
                .prix(12.00)
                .build()
        );
        pizzaList.add(Pizza.builder()
                .id_pizza(4)
                .nom("CAN")
                .description("La Cannibal")
                .prix(12.50)
                .build()
        );
        pizzaList.add(Pizza.builder()
                .id_pizza(5)
                .nom("SAV")
                .description("La Savoyard")
                .prix(13.00)
                .build()
        );
        pizzaList.add(Pizza.builder()
                .id_pizza(6)
                .nom("ORI")
                .description("L'Oriental")
                .prix(13.50)
                .build()
        );
        pizzaList.add(Pizza.builder()
                .id_pizza(7)
                .nom("IND")
                .description("L'Indienne'")
                .prix(14.00)
                .build()
        );

        return pizzaList;
    }
}
