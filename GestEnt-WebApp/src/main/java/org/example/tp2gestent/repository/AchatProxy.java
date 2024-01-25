package org.example.tp2gestent.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.tp2gestent.CustomProperties;
import org.example.tp2gestent.model.Achat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class AchatProxy {

    @Autowired
    private CustomProperties props;


    public Iterable<Achat> getAchats(){
        String baseApiUrl = props.getApiUrl();
        String getAchatUrl = baseApiUrl + "/achats";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Achat>> response = restTemplate.exchange(
                getAchatUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Achat>>() {}
        );

        log.debug("Get Achats call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Achat getAchat(Integer id) {
        String baseApiUrl = props.getApiUrl();
        String getAchatUrl = baseApiUrl + "/achat/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Achat> response = restTemplate.exchange(
                getAchatUrl,
                HttpMethod.GET,
                null,
                Achat.class
        );

        log.debug("Get Achat call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Achat createAchat(Achat a) {
        String baseApiUrl = props.getApiUrl();
        String createAchatUrl = baseApiUrl + "/achat";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Achat> request = new HttpEntity<Achat>(a);
        ResponseEntity<Achat> response = restTemplate.exchange(
                createAchatUrl,
                HttpMethod.POST,
                request,
                Achat.class);

        log.debug("Create Achat call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Achat updateAchat(Achat a) {
        String baseApiUrl = props.getApiUrl();
        String updateAchatUrl = baseApiUrl + "/achat/" + a.getAchatId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Achat> request = new HttpEntity<Achat>(a);
        ResponseEntity<Achat> response = restTemplate.exchange(
                updateAchatUrl,
                HttpMethod.PUT,
                request,
                Achat.class);

        log.debug("Update Achat call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public void deleteAchat(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteAchatUrl = baseApiUrl + "/achat/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteAchatUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Achat call " + response.getStatusCode().toString());
    }

}
