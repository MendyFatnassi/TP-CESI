package org.example.service.impl;

import org.example.service.MenuService;

public class MenuServiceImpl implements MenuService {

    @Override
    public void afficherMenu(){
        System.out.println("1: Afficher Menu");
        System.out.println("2: Ajouter Pizza");
        System.out.println("3: Modifier Pizza");
        System.out.println("4: Supprimer Pizza");
    }
}
