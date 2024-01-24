package org.example.service;

import org.example.modele.Pizza;

import java.util.List;

public interface PizzaService {

    void afficherMenu(List<Pizza> pizzaList);

    Pizza ajouterPizza(List<Pizza> pizzaList);

    void modifierPizza(List<Pizza> pizzaList);

    void supprimerPizza(List<Pizza> pizzaList);
}
