package org.example.tp2gestent.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.tp2gestent.CustomProperties;
import org.example.tp2gestent.model.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class EntrepriseProxy  {

    @Autowired
    private CustomProperties props;


    public Iterable<Entreprise> getEntreprises(){
        String baseApiUrl = props.getApiUrl();
        String getEntrepriseUrl = baseApiUrl + "/Entreprises";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Entreprise>> response = restTemplate.exchange(
                getEntrepriseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Entreprise>>() {}
        );

        log.debug("Get Entreprises call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Entreprise getEntreprise(Integer id) {
        String baseApiUrl = props.getApiUrl();
        String getEntrepriseUrl = baseApiUrl + "/Entreprise/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Entreprise> response = restTemplate.exchange(
                getEntrepriseUrl,
                HttpMethod.GET,
                null,
                Entreprise.class
        );

        log.debug("Get Entreprise call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Entreprise createEntreprise(Entreprise c) {
        String baseApiUrl = props.getApiUrl();
        String createEntrepriseUrl = baseApiUrl + "/achat";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Entreprise> request = new HttpEntity<Entreprise>(c);
        ResponseEntity<Entreprise> response = restTemplate.exchange(
                createEntrepriseUrl,
                HttpMethod.POST,
                request,
                Entreprise.class);

        log.debug("Create Entreprise call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Entreprise updateEntreprise(Entreprise c) {
        String baseApiUrl = props.getApiUrl();
        String updateEntrepriseUrl = baseApiUrl + "/entreprise/" + c.getEntrepriseId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Entreprise> request = new HttpEntity<Entreprise>(c);
        ResponseEntity<Entreprise> response = restTemplate.exchange(
                updateEntrepriseUrl,
                HttpMethod.PUT,
                request,
                Entreprise.class);

        log.debug("Update Entreprise call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteEntreprise(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteEntrepriseUrl = baseApiUrl + "/entreprise/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteEntrepriseUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Entreprise call " + response.getStatusCode().toString());
    }
}
