package org.example.tp2gestent.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.tp2gestent.CustomProperties;
import org.example.tp2gestent.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ProduitProxy  {

    @Autowired
    private CustomProperties props;


    public Iterable<Produit> getProduits(){
        String baseApiUrl = props.getApiUrl();
        String getProduitUrl = baseApiUrl + "/Produits";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Produit>> response = restTemplate.exchange(
                getProduitUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Produit>>() {}
        );

        log.debug("Get Produits call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Produit getProduit(Integer id) {
        String baseApiUrl = props.getApiUrl();
        String getProduitUrl = baseApiUrl + "/Produit/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Produit> response = restTemplate.exchange(
                getProduitUrl,
                HttpMethod.GET,
                null,
                Produit.class
        );

        log.debug("Get Produit call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Produit createProduit(Produit c) {
        String baseApiUrl = props.getApiUrl();
        String createProduitUrl = baseApiUrl + "/Produit";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Produit> request = new HttpEntity<Produit>(c);
        ResponseEntity<Produit> response = restTemplate.exchange(
                createProduitUrl,
                HttpMethod.POST,
                request,
                Produit.class);

        log.debug("Create Produit call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Produit updateProduit(Produit c) {
        String baseApiUrl = props.getApiUrl();
        String updateProduitUrl = baseApiUrl + "/achat/" + c.getProduitId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Produit> request = new HttpEntity<Produit>(c);
        ResponseEntity<Produit> response = restTemplate.exchange(
                updateProduitUrl,
                HttpMethod.PUT,
                request,
                Produit.class);

        log.debug("Update Produit call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteProduit(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteProduitUrl = baseApiUrl + "/achat/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteProduitUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Produit call " + response.getStatusCode().toString());
    }
}