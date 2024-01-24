package org.example;

import org.example.modele.Pizza;
import org.example.service.InitialisationService;
import org.example.service.MenuService;
import org.example.service.PizzaService;
import org.example.service.impl.InitialisationServiceImpl;
import org.example.service.impl.MenuServiceImpl;
import org.example.service.impl.PizzaServiceImpl;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        InitialisationService initialisationService = new InitialisationServiceImpl();
        PizzaService pizzaService = new PizzaServiceImpl();
        MenuService menuService = new  MenuServiceImpl();

        List<Pizza> pizzaList = initialisationService.initPizzaTab();

        menuService.afficherMenu();


        int choix=1;

        while(choix != 0){
            Scanner sc = new Scanner(System.in);

            System.out.println("Votre Choix : ");
            choix = sc.nextInt();

            switch (choix){
                case 1 :
                    pizzaService.afficherMenu(pizzaList);
                    menuService.afficherMenu();
                    break;
                case 2 :
                    Pizza pizza ;
                    pizza = pizzaService.ajouterPizza(pizzaList);
                    pizzaList.add(pizza);
                    menuService.afficherMenu();
                    break;
                case 3 :
                    pizzaService.modifierPizza(pizzaList);
                    menuService.afficherMenu();
                    break;
                case 4 :
                    pizzaService.supprimerPizza(pizzaList);
                    menuService.afficherMenu();
                    break;
                default:
                    System.out.println("Erreur de saisie !!!");
                    break;
            }
        }
        System.out.println("Fin du programme !!!");
    }
}