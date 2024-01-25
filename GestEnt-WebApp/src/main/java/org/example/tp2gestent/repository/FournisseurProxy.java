package org.example.tp2gestent.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.tp2gestent.CustomProperties;
import org.example.tp2gestent.model.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class FournisseurProxy  {

    @Autowired
    private CustomProperties props;


    public Iterable<Fournisseur> getFournisseurs(){
        String baseApiUrl = props.getApiUrl();
        String getFournisseurUrl = baseApiUrl + "/Fournisseurs";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Fournisseur>> response = restTemplate.exchange(
                getFournisseurUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Fournisseur>>() {}
        );

        log.debug("Get Fournisseurs call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Fournisseur getFournisseur(Integer id) {
        String baseApiUrl = props.getApiUrl();
        String getFournisseurUrl = baseApiUrl + "/Fournisseur/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Fournisseur> response = restTemplate.exchange(
                getFournisseurUrl,
                HttpMethod.GET,
                null,
                Fournisseur.class
        );

        log.debug("Get Fournisseur call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Fournisseur createFournisseur(Fournisseur c) {
        String baseApiUrl = props.getApiUrl();
        String createFournisseurUrl = baseApiUrl + "/Fournisseur";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Fournisseur> request = new HttpEntity<Fournisseur>(c);
        ResponseEntity<Fournisseur> response = restTemplate.exchange(
                createFournisseurUrl,
                HttpMethod.POST,
                request,
                Fournisseur.class);

        log.debug("Create Fournisseur call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Fournisseur updateAchat(Fournisseur c) {
        String baseApiUrl = props.getApiUrl();
        String updateFournisseurUrl = baseApiUrl + "/achat/" + c.getFournisseurId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Fournisseur> request = new HttpEntity<Fournisseur>(c);
        ResponseEntity<Fournisseur> response = restTemplate.exchange(
                updateFournisseurUrl,
                HttpMethod.PUT,
                request,
                Fournisseur.class);

        log.debug("Update Fournisseur call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteFournisseur(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteFournisseurUrl = baseApiUrl + "/achat/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteFournisseurUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Fournisseur call " + response.getStatusCode().toString());
    }
}
