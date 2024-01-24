package org.example.service.impl;

import org.example.modele.Pizza;
import org.example.service.PizzaService;

import java.util.List;
import java.util.Scanner;

public class PizzaServiceImpl implements PizzaService {


    @Override
    public void afficherMenu(List<Pizza> pizzaList) {
        for (Pizza pizza : pizzaList) {
            System.out.println(pizza.getId_pizza()+" "+ pizza.getNom() + "->" + pizza.getDescription() + "(" + pizza.getPrix() + ")");
        }
        System.out.println("\n\n");
    }

    @Override
    public Pizza ajouterPizza(List<Pizza> pizzaList){
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez saisir le nom : ");
        String nom = sc.nextLine();
        System.out.println("Veuillez saisir la description (sans espace) : ");
        String description = sc.nextLine();
        System.out.println("Veuillez saisir le prix : ");
        double prix = sc.nextDouble();

        return Pizza.builder().id_pizza(pizzaList.size()).nom(nom).description(description).prix(prix).build();
    }

    @Override
    public void modifierPizza(List<Pizza> pizzaList){
        Pizza pizzaModif = new Pizza();

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez choisir l'indice de la pizza a modifier : ");
        Integer indice = sc.nextInt();

        System.out.println("Veuilez siasir le nouveau nom : ");
        sc.nextLine();
        String nomModif = sc.nextLine();
        System.out.println("Veuillez saisir la nouvelle description : ");
        String descModif = sc.nextLine();
        System.out.println("Veuillez saisir le nouveau prix : ");
        double prixModif = sc.nextDouble();

        pizzaModif.setId_pizza(pizzaList.get(indice).getId_pizza());
        pizzaModif.setNom(nomModif);
        pizzaModif.setDescription(descModif);
        pizzaModif.setPrix(prixModif);

        pizzaList.set(indice,pizzaModif);

    }

    @Override
    public void supprimerPizza(List<Pizza> pizzaList){
        Scanner sc = new Scanner (System.in);
        System.out.println("veuillez saisir l'id de la pizza a supprimer : ");
        int indexe = sc.nextInt();

        pizzaList.remove(Pizza.builder()
                .id_pizza(indexe)
                .nom(pizzaList.get(indexe).getNom())
                .description(pizzaList.get(indexe).getDescription())
                .prix(pizzaList.get(indexe).getPrix())
                .build()
        );
    }

}
