package org.example.tp2gestent.model;

import lombok.Data;

import java.util.List;

@Data
public class Client {

    private Integer clientId;
    private Integer numeroClient;
    private List<Achat> historiqueAchat;

}